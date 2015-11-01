package com.awbeci.service;

import com.awbeci.domain.UserCategory;

import java.util.List;

public interface IUserCategoryService {
    List<UserCategory> selectCategoryByUid(String uid);
}
