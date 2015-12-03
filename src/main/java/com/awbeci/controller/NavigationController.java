package com.awbeci.controller;

import com.awbeci.domain.UserCategory;
import com.awbeci.domain.UserSites;
import com.awbeci.service.IUserCategoryService;
import com.awbeci.service.IUserSitesService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.awbeci.aliyun.oss.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class NavigationController {

    Logger log = LoggerFactory.getLogger(NavigationController.class);

    @Autowired
    private IUserCategoryService userCategoryService;

    @Autowired
    private IUserSitesService userSitesService;

    @RequestMapping("/navigation/navigation.html")
    public String navigation(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
            return "navigation/navigation";
        }
    }


    @RequestMapping(value = "/json/getCategoryByUid.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCategory> selectAllCategory(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List<UserCategory> userCategories = userCategoryService.selectCategoryByUid(uid);
            return userCategories;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/json/getCategoryParent.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCategory> selectCategoryParent(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List<UserCategory> userCategories = userCategoryService.selectCategoryParent(uid);
            return userCategories;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/json/getCategoryChildByPid.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCategory> getCategoryChildByPid(String pid, HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List<UserCategory> userCategories = userCategoryService.selectCategoryChildByPid(pid);
            return userCategories;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/json/getCategoryChild.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserCategory> getCategoryChild(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List<UserCategory> userCategories = userCategoryService.selectCategoryChild();
            return userCategories;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/json/saveCategory.json", method = RequestMethod.POST)
    @ResponseBody
    public int saveCategory(UserCategory userCategory, HttpServletRequest request, HttpSession session) {
        String flag = request.getParameter("flag");
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {

            userCategory.setUpdateDt(new Date());

            if (flag.equals("add")) {
                userCategory.setId(UUID.randomUUID().toString());
                userCategory.setUid(uid);
                userCategory.setSortNo(1);
                userCategory.setCreateDt(new Date());
                int val = userCategoryService.insertCategory(userCategory);
                return val;
            }
            if (flag.equals("update")) {
                int val = userCategoryService.updateCategoryById(userCategory);
                return val;
            }
            return 0;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/json/saveSite.json", method = RequestMethod.POST)
    @ResponseBody
    public int saveSite(UserSites userSites, HttpServletRequest request, HttpSession session) throws IOException {
        String flag = request.getParameter("flag");
        String uid = (String) session.getAttribute("uid");
        String properties = "aliyun-oss.properties";
        if (uid != null) {
            return userSitesService.saveSite(flag, properties, userSites);
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/json/deleteSite.json", method = RequestMethod.POST)
    @ResponseBody
    public int deleteSite(String id, String iconurl, HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            String properties = "aliyun-oss.properties";
            int val = userSitesService.deleteSite(properties, id, iconurl);
            return val;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/json/deleteCategory.json", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCategory(String id, HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            int val = userCategoryService.deleteCategory(id);
            return val;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/json/getSiteByCategoryId.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserSites> getSiteByCategoryId(String categoryId, HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List userSites = userSitesService.getSiteByCategoryId(categoryId);
            return userSites;
        }
        return null;
    }

    @RequestMapping(value = "/json/getSiteByMostClick.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserSites> getSitesByMostClick(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        if (uid != null) {
            List userSites = userSitesService.getSitesByMostClick();
            return userSites;
        }
        return null;
    }

    @RequestMapping(value = "/json/querySiteByParam.json", method = RequestMethod.POST)
    @ResponseBody
    public List<UserSites> querySiteByParam(String param) {
        try {
                return userSitesService.querySiteByParam(param);
        } catch (Exception e) {
            log.debug("错误原因:" + e.getMessage());
            return null;
        }
    }
}