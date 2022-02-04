package com.ervin.EZSpring.WebEntrance.dao;

import com.ervin.EZSpring.WebEntrance.po.User;
import com.ervin.EZSpring.WebEntrance.query.UserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User getUser(Integer userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    List<User> queryUserByParams(UserQuery userQuery);
}
