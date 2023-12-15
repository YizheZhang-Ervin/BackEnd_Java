package com.ervin.serviceproducer.service;

import com.ervin.serviceproducer.mapper.UserMapper;
import com.ervin.serviceproducer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}