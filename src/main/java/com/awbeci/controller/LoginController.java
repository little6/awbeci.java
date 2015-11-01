package com.awbeci.controller;

import com.awbeci.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.awbeci.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login.html")
    //todo:要判断是否已经登录，如果登录就不需要到登录界面
    public ModelAndView login() {
        return new ModelAndView("login/login");
    }

    /**
     * 登录
     *
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/json/loginIn.json")
    @ResponseBody
    public Map<String, Object> loginIn(String name, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.selectUser(name, password);
        if (user != null) {
            session.setAttribute("user", name);
            session.setAttribute("uid", user.getId());
            //设置session过期时间为一个月
            session.setMaxInactiveInterval(60 * 24 * 31);
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

    /**
     * 退出
     */
    @RequestMapping("/json/loginOut.json")
    @ResponseBody
    public void loginOut(HttpSession session) {
        Object sess = session.getAttribute("user");
    }
}
