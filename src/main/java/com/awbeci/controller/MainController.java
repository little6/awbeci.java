package com.awbeci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhangwei on 2015/7/1.
 */
@Controller
public class MainController {

    //@Autowired
    //private IUserService userService;

    /**
     * 首页页面
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "main/index";
        } else {
            return "/main/main";
        }
    }
}