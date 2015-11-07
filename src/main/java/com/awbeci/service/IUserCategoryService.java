package com.awbeci.service;

import com.awbeci.domain.UserCategory;

import java.util.List;

public interface IUserCategoryService {
    List<UserCategory> selectCategoryParentByUid(String uid);

    int insertCategory(UserCategory userCategory);

    List<UserCategory> selectCategoryChildByPid(String pid);
}
