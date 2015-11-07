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
    public List<UserCategory> selectCategoryParentByUid(String uid) {
        return userCategoryDao.selectCategoryParentByUid(uid);
    }

    @Override
    public int insertCategory(UserCategory userCategory) {
        return userCategoryDao.insertCategory(userCategory);
    }

    @Override
    public List<UserCategory> selectCategoryChildByPid(String pid) {
        return userCategoryDao.selectCategoryChildByPid(pid);
    }
}
