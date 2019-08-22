package com.abc.demo.web.controller;

import com.abc.demo.entity.User;
import com.abc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

         /*1.判断登录是否成功
         2.成功，跳转到欢迎界面
         3.不成功，跳转到重新登录页面
          */

    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        // request.getParameter 后台获取前台页面出传递过来的数据
        // String username=request.getParameter("username");

        //登录判断要和数据库中，存放的数据一致，所以要通过service，调用dao
        //调用方法要传入实际的参数
        User login_user = userService.login(user);
        System.out.println(login_user);
        //login_user.equals("") &&login_user != null  逻辑错误
        //uesr:封装成user对象的话，user对象可能是空，不为空的话，
        // 可以显示出名字，其余的可以是空，比如password可以为空

        if (login_user != null) {
            session.setAttribute("username",user.getUsername());
            return "/success.html";
        } else {
            return "/index.html";
        }

    }
}