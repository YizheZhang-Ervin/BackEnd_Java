package com.ervin.EZSpring.WebEntrance.controller;

import com.ervin.EZSpring.WebEntrance.JMS.Message.LoginMessage;
import com.ervin.EZSpring.WebEntrance.JMS.MessagingService;
import com.ervin.EZSpring.WebEntrance.JMS.Message.RegistrationMessage;
import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserKafkaController {
    final Logger logger = LoggerFactory.getLogger(getClass());
    public static final String KEY_USER = "__user__";
    @Autowired
    UserService userService;

    @Autowired
    MessagingService messagingService;

    @PostMapping("/register2")
    public Map<String,Object> doRegister(@RequestParam("userId") Integer userId, @RequestParam("password") String password,
                                   @RequestParam("name") String name) throws Exception {
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userService.register(name,userId);
            logger.info("user registered: {}", user.getUserName());
            messagingService.sendRegistrationMessage(RegistrationMessage.of(user.getUserId(), user.getUserName()));
        } catch (RuntimeException e) {
            logger.warn(e.getMessage(), e);
            map.put("userId", userId);
            map.put("error", "Register failed");
            return map;
        }
        map.put("OK", "Register success");
        return map;
    }

    @PostMapping("/signin2")
    public Map<String,Object> doSignin(@RequestParam("userId") Integer userId, @RequestParam("name") String name,
                                 HttpSession session) throws IOException {
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userService.signin(name,userId);
            messagingService.sendLoginMessage(LoginMessage.of(user.getUserId(), user.getUserName(), true));
            session.setAttribute(KEY_USER, user);
        } catch (RuntimeException e) {
            messagingService.sendLoginMessage(LoginMessage.of(userId, "(unknown)", false));
            map.put("userId", userId);
            map.put("error", "Signin failed");
            return map;
        }
        map.put("OK", "Signin success");
        return map;
    }
}
