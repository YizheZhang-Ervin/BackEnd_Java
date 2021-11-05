package com.ervin.EZSpring.WebEntrance.controller;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.service.RedisService;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UserRedisController {

    public static final String KEY_USER_ID = "__userid__";
    public static final String KEY_USERS = "__users__";

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RedisService redisService;
    @Resource
    private UserService userService;

    // 把User写入Redis:
    private void putUserIntoRedis(User user) throws Exception {
        redisService.hset(KEY_USERS, user.getUserId().toString(), objectMapper.writeValueAsString(user));
    }

    // 从Redis读取User:
    private User getUserFromRedis(HttpSession session) throws Exception {
        Long id = (Long) session.getAttribute(KEY_USER_ID);
        if (id != null) {
            String s = redisService.hget(KEY_USERS, id.toString());
            if (s != null) {
                return objectMapper.readValue(s, User.class);
            }
        }
        return null;
    }
    @PostMapping("/signin")
    public Map<String,Object> doSignin(@RequestParam("name") String name, @RequestParam("userId") Integer userId, HttpSession session) throws Exception {
        Map<String,Object> map = new HashMap<>();
        try {
            User user = userService.signin(name, userId);
            session.setAttribute(KEY_USER_ID, user.getUserId());
            putUserIntoRedis(user);
        } catch (RuntimeException e) {
            map.put("userId", userId);
            map.put("error", "Signin failed");
            return map;
        }
        map.put("OK", "Signin success");
        return map;
    }

    @GetMapping("/profile")
    public Map<String,Object> profile(HttpSession session) throws Exception {
        User user = getUserFromRedis(session);
        Map<String,Object> map = new HashMap<>();
        if (user == null) {
            map.put("error", "user is null");
            return map;
        }
        map.put("user", user);
        return map;
    }
}
