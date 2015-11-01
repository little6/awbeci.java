package com.awbeci.service.spring;

import com.awbeci.dao.IUserCategoryDao;
import com.awbeci.domain.UserCategory;
import com.awbeci.service.IUserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCagetoryImpl implements IUserCategoryService{
    @Autowired
    private IUserCategoryDao userCategoryDao;

    @Override
    public List<UserCategory> selectCategoryByUid(String uid) {
        return userCategoryDao.selectCategoryByUid(uid);
    }
}
