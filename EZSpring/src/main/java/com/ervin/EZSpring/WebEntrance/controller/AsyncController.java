package com.ervin.EZSpring.WebEntrance.controller;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class AsyncController {
    @Resource
    private UserService userService;

    @GetMapping("/async/users")
    public Callable<User> users() {
        return () -> {
            // 模拟3秒耗时:
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return userService.getUser(001);
        };
    }
    @GetMapping("/async/users/{id}")
    public DeferredResult<User> user(@PathVariable("id") int id) {
        DeferredResult<User> result = new DeferredResult<>(3000L); // 3秒超时
        new Thread(() -> {
            // 等待1秒:
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            try {
                User user = userService.getUser(id);
                // 设置正常结果并由Spring MVC写入Response:
                result.setResult(user);
            } catch (Exception e) {
                // 设置错误结果并由Spring MVC写入Response:
                Map<String,Object> map = new HashMap<>();
                map.put("error", e.getClass().getSimpleName());
                map.put("message", e.getMessage());
                result.setErrorResult(map);
            }
        }).start();
        return result;
    }
}
