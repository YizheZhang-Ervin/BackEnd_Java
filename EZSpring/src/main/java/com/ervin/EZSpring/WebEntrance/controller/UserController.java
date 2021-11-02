package com.ervin.EZSpring.WebEntrance.controller;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.query.UserQuery;
import com.ervin.EZSpring.WebEntrance.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags="manage user")
@RestController
//@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/{userId}")
    @ApiOperation(value="get user")
    @ApiImplicitParam(name="userId",value="user id",required = true,paramType = "path")
    public String GetUser(@PathVariable Integer userId){
        return userService.getUser(userId).toString();
    }

    @PostMapping("user")
    @ApiOperation(value="add user")
    @ApiImplicitParam(name="user",value="user")
    public Map<String,Object> addUser(@RequestBody User user){
        userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @PostMapping("user2")
    @ApiOperation(value="add user2")
    @ApiImplicitParam(name="user2",value="user2")
    public Map<String,Object> addUser2(@Valid User user){
        userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @PutMapping("user")
    @ApiOperation(value="update user")
    @ApiImplicitParam(name="user",value="user")
    // 不推荐使用@RequestParam接收application/json，这时候就需要使用到@RequestBody。
    public Map<String,Object> updateUser(@RequestBody User user){
        userService.updateUser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }

    @DeleteMapping("user/{userId}")
    @ApiOperation(value="delete user")
    @ApiImplicitParam(name="userId",value="user id",required = true,paramType = "path")
    public Map<String,Object> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","succeed");
        return map;
    }
    // Request 接受任何类型请求
    @RequestMapping("list")
    @ApiOperation(value="get user list")
    @ApiImplicitParam(name="userQuery",value="user query")
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        return userService.queryUserByParams(userQuery);
    }
}