package com.awbeci.controller;

import com.awbeci.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.awbeci.service.ILinkService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhangwei on 2015/5/17.
 */
@Controller
public class NavigationController {
    @Autowired
    private ILinkService linkService;

    @RequestMapping("/navigation/navigation.html")
    public String navigation(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
            return "navigation/navigation";
        }
    }
}