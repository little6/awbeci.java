package com.awbeci.controller;

import com.awbeci.domain.UserCategory;
import com.awbeci.service.IUserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangwei on 2015/5/17.
 */
@Controller
public class NavigationController {
    @Autowired
    private IUserCategoryService userCategoryService;

    @RequestMapping("/navigation/navigation.html")
    public String navigation(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
            return "navigation/navigation";
        }
    }

    /**
     * 根据uid获取类别
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/json/getCategoryByUid.json", method = RequestMethod.GET)
    @ResponseBody
    public List<UserCategory> getCategoryByUid(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List<UserCategory> userCategories = userCategoryService.selectCategoryByUid(uid);
            return userCategories;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/json/saveCategory.json", method = RequestMethod.GET)
    @ResponseBody
    public int insertCategory(UserCategory userCategory, HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            userCategory.setId(UUID.randomUUID().toString());
            userCategory.setUid(uid);
            userCategory.setSortNo(1);
            userCategory.setCreateDt(new Date());
            userCategory.setUpdateDt(new Date());
            int val = userCategoryService.insertCategory(userCategory);
            return val;
        } else {
            return 0;
        }
    }
}