package com.awbeci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    //@Autowired
    //private ILinkService linkService;

    /**
     * 首页页面
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        //List<Link> list = linkService.selectLinkById();
        if (session.getAttribute("user") == null) {
            return "main/index";
        } else {
            return "/main/main";
        }
    }

    @RequestMapping("/main/main.html")
    public String main(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "main/index";
        } else {
            return "/main/main";
        }
    }
}