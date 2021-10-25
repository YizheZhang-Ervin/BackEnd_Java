package com.ervin.EZSpring;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={EzSpringApplicationTests.class})
public class EzTestService {
    @Resource
    UserService userService;

    private final Logger log = LoggerFactory.getLogger(EzTestService.class);

    @Before
    public void before(){
        log.info("before");
    }

    @Test
    public void testGetUser(){
        User user = userService.getUser(1);
    }

    @After
    public void after(){
        log.info("after");
    }
}
