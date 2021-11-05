package com.ervin.EZSpring.WebEntrance.service;

import com.ervin.EZSpring.WebEntrance.dao.UserDao;
import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    final Logger logger = LoggerFactory.getLogger(getClass());

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

    public User signin(String name, Integer userId) {
        logger.info("try login by {}...", userId);
        User user = getUser(userId);
        if (user.getUserName().equals(name)) {
            return user;
        }
        throw new RuntimeException("login failed.");
    }

    public User register(String name,Integer userId) {
        logger.info("try register by {}...", userId);
        User user = new User();
        user.setUserName(name);
        addUser(user);
        return user;
    }
}