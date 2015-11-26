package com.awbeci.service.spring;

import com.awbeci.aliyun.oss.BucketObject;
import com.awbeci.dao.IUserSitesDao;
import com.awbeci.domain.UserCategory;
import com.awbeci.domain.UserSites;
import com.awbeci.service.IUserSitesService;
import com.awbeci.util.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

@Service
public class UserSitesImpl implements IUserSitesService {

    @Autowired
    private IUserSitesDao userSitesDao;

    Logger log = LoggerFactory.getLogger(BucketObject.class);
    MyProperties myProperties = new MyProperties();

    @Override
    public List<UserSites> getSiteByCategoryId(String categoryid) {
        return userSitesDao.getSiteByCategoryId(categoryid);
    }

    /**
     * 保存网址
     * @param flag 判断是添加还是修改
     * @param properties 配置文件
     * @param userSites site实体类
     * @return
     */
    @Override
    public int saveSite(String flag, String properties, UserSites userSites) {
        try {
            Properties prop = myProperties.getPropertiesByName(properties);
            Date date = new Date();
            String searchapi = prop.getProperty("searchapi");
            String ossurl = prop.getProperty("ossurl");
            String bucketfolder = prop.getProperty("bucketfolder");
            String defaultico = prop.getProperty("defaultico");
            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String favicon = format.format(new Date()) + ".ico";

            BucketObject bucketObject = new BucketObject(properties);
            boolean data = bucketObject.putObject(bucketfolder, favicon, searchapi + userSites.getUrl());
            String icon = ossurl + bucketfolder + favicon;
            if (!data) {
                //设置成默认的图片
                icon = ossurl + bucketfolder + defaultico;
            }
            userSites.setIcon(icon);
            userSites.setSortNo(1);
            userSites.setUpdateDt(date);

            if (flag.equals("add")) {
                userSites.setId(UUID.randomUUID().toString());
                userSites.setCreateDt(date);
                int val = userSitesDao.insertSite(userSites);
                return val;
            }
            if (flag.equals("update")) {
                int val = userSitesDao.updateSite(userSites);
                return val;
            }
            return 0;
        } catch (Exception e) {
            log.error("出错:" + e.getMessage());
            return 0;
        }
    }

    @Override
    public List<UserSites> getSitesByMostClick() {
        return userSitesDao.getSitesByMostClick();
    }

    @Override
    public int deleteSite(String id) {
        return userSitesDao.deleteSite(id);
    }
}
