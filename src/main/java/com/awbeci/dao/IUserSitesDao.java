package com.awbeci.dao;

import com.awbeci.domain.UserSites;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserSitesDao {

    @Select("select * from usersites where categoryId=#{categoryId}")
    List<UserSites> getSiteByCategoryId(String categoryId);

    @Insert("insert into usersites(id,categoryId,name,url,icon,sortno,createdt,updatedt)" +
            "values(#{id},#{categoryId},#{name},#{url},#{icon},#{sortNo},#{createDt},#{updateDt})")
    int insertSite(UserSites userSites);

    //todo:根据点击次数>100查询数据，暂时先查询所有
    @Select("select * from usersites")
    List<UserSites> getSitesByMostClick();
}
