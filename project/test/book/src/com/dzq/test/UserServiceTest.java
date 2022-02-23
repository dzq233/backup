package com.dzq.test;

import com.dzq.pojo.User;
import com.dzq.service.Impl.UserServiceImpl;
import com.dzq.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService= new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666","bbj168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"dzq233","123456","null")));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("dzq233")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}