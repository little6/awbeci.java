package com.awbeci.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by zhangwei on 2015/10/8.
 */
@Controller
public class UserInfoController {

    @RequestMapping("/settings/account")
    public ModelAndView login() {
        return new ModelAndView("user/showInfo");
    }

    @RequestMapping("/following")
    public ModelAndView following() {
        return new ModelAndView("user/following");
    }

    @RequestMapping("/followers")
    public ModelAndView followers() {
        return new ModelAndView("user/followers");
    }
}
