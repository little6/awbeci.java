package com.awbeci.dao;

import com.awbeci.domain.User;
import com.awbeci.domain.UserCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserCategoryDao {

    @Select("select * from usercategory where uid=#{uid}")
    List<UserCategory> selectCategoryByUid(String uid);

    @Insert("insert into usercategory(id,uid,pid,name,sortno,createdt,updatedt)" +
            "values(#{id},#{uid},#{pid},#{name},#{sortNo},#{createDt},#{updateDt})")
    int insertCategory(UserCategory userCategory);
}
