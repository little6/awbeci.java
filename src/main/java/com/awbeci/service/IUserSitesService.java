package com.awbeci.service;

import com.awbeci.domain.UserSites;

import java.util.List;

public interface IUserSitesService {

    List<UserSites> getSiteByCategoryId(String categoryid);

    int insertSite(UserSites userSites);
}