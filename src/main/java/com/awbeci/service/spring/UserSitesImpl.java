package com.awbeci.service.spring;

import com.awbeci.dao.IUserSitesDao;
import com.awbeci.domain.UserCategory;
import com.awbeci.domain.UserSites;
import com.awbeci.service.IUserSitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSitesImpl implements IUserSitesService {

    @Autowired
    private IUserSitesDao userSitesDao;

    @Override
    public List<UserSites> getSiteByCategoryId(String categoryid) {
        return userSitesDao.getSiteByCategoryId(categoryid);
    }
}
