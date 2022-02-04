package com.ervin.EZSpring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={EzSpringApplicationTests.class})
@AutoConfigureMockMvc
public class EzTestController {
    @Autowired
    MockMvc mockMvc;

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void testGetUser() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/1")
                .contentType("text/html")
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8");
        ResultActions perform = mockMvc.perform(builder);
        perform.andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult result = perform.andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(response.getStatus());
        System.out.println(response.getContentAsString());
    }

    @After
    public void after(){
        System.out.println("after");
    }
}
