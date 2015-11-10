package com.awbeci.service;

import com.awbeci.domain.UserCategory;

import java.util.List;

public interface IUserCategoryService {
    List<UserCategory> selectCategoryByUid(String uid);

    List<UserCategory> selectCategoryParent(String uid);

    int insertCategory(UserCategory userCategory);

    List<UserCategory> selectCategoryChildByPid(String pid);

    int updateCategoryById(UserCategory userCategory);

    int deleteCategory(String id);

}
