package com.awbeci.service;

import com.awbeci.domain.User;

import java.util.List;

/**
 * Created by zhangwei on 2015/10/18.
 */
public interface IUserService {
    List<User> selectUser();

    User selectUser(String name, String passwd);

    public boolean region(User newUser,String properties);

    int validateEmail(String id);

    User selectUserByName(String name);
}
