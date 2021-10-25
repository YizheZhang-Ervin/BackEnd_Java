package com.ervin.EZSpring.WebEntrance.controller;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.query.UserQuery;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/{userId}")
    public String GetUser(@PathVariable Integer userId){
        return userService.getUser(userId).toString();
    }

    @PostMapping("user")
    public Map<String,Object> addUser(@RequestBody User user){
        userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @PostMapping("user2")
    public Map<String,Object> addUser2(@Valid User user){
        userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @PutMapping("user")
    // 不推荐使用@RequestParam接收application/json，这时候就需要使用到@RequestBody。
    public Map<String,Object> updateUser(@RequestBody User user){
        userService.updateUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @DeleteMapping("user/{userId}")
    public Map<String,Object> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }
    // Request 接受任何类型请求
    @RequestMapping("list")
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        return userService.queryUserByParams(userQuery);
    }
}
