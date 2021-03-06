package com.awbeci.service;

import com.awbeci.domain.User;
import com.awbeci.domain.UserSites;

import java.io.InputStream;
import java.util.List;

public interface IUserSitesService {

    List<UserSites> getSiteByCategoryId(String categoryid);

    int saveSite(String flag, String properties, UserSites userSites);

    List<UserSites> getSitesByMostClick(String id);

    int deleteSite(String properties, String id, String iconUrl);

    List<UserSites> querySiteByParam(String param);

    String uploadAvatar(String properties,InputStream content,String uid,String avatarImgUrl);
}
