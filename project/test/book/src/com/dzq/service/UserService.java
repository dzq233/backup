package com.dzq.service;

import com.dzq.pojo.User;

public interface UserService {
    //注册用户
    public void registUser(User user);

    //登陆
    public User login(User user);
    //如果返回null,说明登陆失败

    //检查用户名是否可用
    //返回true表示用户名已存在，返回false表示用户名可用
    public boolean existUsername(String username);
}