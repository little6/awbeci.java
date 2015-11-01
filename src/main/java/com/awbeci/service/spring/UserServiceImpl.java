package com.awbeci.service.spring;

import com.awbeci.dao.IUserDao;
import com.awbeci.domain.User;
import com.awbeci.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public User selectUser(String name, String passwd) {
        return userDao.selectUserByParam(name, passwd);
    }
}
