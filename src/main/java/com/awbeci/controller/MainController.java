package com.awbeci.controller;

import com.awbeci.domain.User;
import com.awbeci.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private IUserService userService;

    /**
     * 网站主页
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            //跳转到快速注册页面
            return "main/index";
        } else {
            //跳转到awbeci主页
            return "/main/main";
        }
    }

    /**
     * 导航到用户个人主页
     *
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public String usersPage(@PathVariable String username, HttpSession session) {
        User data = userService.selectUserByName(username);
        if (data == null) {
            return "error/404";
        } else {
            session.setAttribute("uid", data.getId());
            return "navigation/navigation";
        }
    }

    @RequestMapping("/json/getSession.json")
    @ResponseBody
    public Map<String, Object> loginIn(HttpSession session) {
        Object username = session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        if (username == null) {
            map.put("session", null);
        } else {
            map.put("session", username);
        }
        return map;
    }
}