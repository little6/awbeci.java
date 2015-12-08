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

import javax.servlet.http.HttpServletRequest;
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
     * 注册
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/region.html")
    public String region(User user, HttpSession session) throws Exception {
        Object sessionuser = session.getAttribute("user");
        String properties = "awbeci.properties";
        if (sessionuser != null) {
            return "/main/main.html";
        }
        boolean data = userService.sendEmail(user, properties);
        if (data) {
            //设置session
            session.setAttribute("user", user.getName());
            session.setAttribute("uid", user.getId());
            //todo:跳转不成功
            return "/main/main.html";
        } else {
            //邮件发送失败
            return "/";
        }
    }

//    /**
//     * 验证邮箱
//     *
//     * @return
//     */
//    @RequestMapping("/validate/validateEmail.html")
//    public ModelAndView validateEmail(HttpServletRequest request) {
//        ModelAndView view = new ModelAndView("validate/validateEmail");
//        String activecode = request.getParameter("activecode");
//        //boolean data = userService.validateEmail(activecode);
////        if (data) {
////            view.addObject("message", "验证成功，正在跳转中...");
////        } else {
////            view.addObject("message", "验证失败，正在跳转中...");
////        }
//        return null;
//    }
//}

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
            session.setAttribute("user", user.getName());
            session.setAttribute("uid", user.getId());
            //设置session过期时间为一年
            session.setMaxInactiveInterval(60 * 24 * 30);
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
    public Map<String, Object> loginOut(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        session.invalidate();
        map.put("success", true);
        return map;
    }
}
