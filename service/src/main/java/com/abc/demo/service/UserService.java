package com.abc.demo.service;

import com.abc.demo.dao.UserDao;
import com.abc.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//加入 spring
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    /*
    select username from user where username=#{username} and password=#{password}
     */
    public User login(User user){

        User login = userDao.login(user);
        return login;
    }
}
