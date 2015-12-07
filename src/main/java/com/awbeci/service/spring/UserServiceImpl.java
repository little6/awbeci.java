package com.awbeci.service.spring;

import com.awbeci.dao.IUserDao;
import com.awbeci.domain.User;
import com.awbeci.service.IUserService;
import com.awbeci.util.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

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

    @Override
    public boolean sendEmail(User newUser){
        Email emailUtil = new Email();

        User user = new User();
        //设置激活码
        UUID id = UUID.randomUUID();
        user.setActivationKey(id.toString());
        user.setPassword(newUser.getPassword());
        user.setStatus(0);
        user.setCreateDt(new Timestamp(System.currentTimeMillis()));
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setUpdateDt(new Timestamp(System.currentTimeMillis()));

        boolean data = emailUtil.sendEmail(newUser.getEmail(), "来自Awbeci的注册邮件",
                "<html><head></head><body><p>您好,<br>" +
                        "感谢您通过Awbeci注册.<br>" +
                        "点击以下链接验证您的邮箱地址：</p>" +
                        "<a href='http://localhost:8080/validate/validateEmail.html?activecode=" + id + "'>" +
                        "http://localhost:8080/validate/validateEmail.html?activecode=" + id + "</a>" +
                        "</body></html>");
        //邮件发送成功
        if (data) {
            //todo:
            //userDAO.insertUser(user);
            return true;
        }
        else {
            return false;
        }
    }
}
