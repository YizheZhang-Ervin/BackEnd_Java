package com.ervin.EZSpring.WebEntrance.service;

import com.ervin.EZSpring.WebEntrance.dao.UserDao;
import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    @Cacheable(value="users",key="#userId")
    public User getUser(Integer userId){
        return userDao.getUser(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user){
        userDao.addUser(user);
    }

    @CachePut(value="users",key="#user.userId")
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    @CacheEvict(value="users",key="#userId",allEntries = false,beforeInvocation = false)
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer userId){
        userDao.deleteUser(userId);
    }

    @Cacheable(value="users",key="#userQuery.pageNum+'-'+#userQuery.pageSize+'-'+#userQuery.userName")
    // 多个查询条件则key = "#xx.a +‘-’+ xx.b",根据任意一个条件查都会缓存
    public PageInfo<User> queryUserByParams(UserQuery userQuery){
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());// 分页
        List<User> userList = userDao.queryUserByParams(userQuery); // 查询
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}