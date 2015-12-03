package com.awbeci.dao;

import com.awbeci.domain.User;
import com.awbeci.domain.UserSites;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserSitesDao {

    @Select("select * from usersites where categoryId=#{categoryId}")
    List<UserSites> getSiteByCategoryId(String categoryId);

    @Insert("insert into usersites(id,categoryId,name,url,icon,sortno,createdt,updatedt)" +
            "values(#{id},#{categoryId},#{name},#{url},#{icon},#{sortNo},#{createDt},#{updateDt})")
    int insertSite(UserSites userSites);

    @Update("update usersites set " +
            "categoryId=#{categoryId},name=#{name},url=#{url},icon=#{icon},sortno=#{sortNo},updatedt=#{updateDt} " +
            "where id=#{id}")
    int updateSite(UserSites userSites);

    //todo:根据点击次数>100查询数据，暂时先查询所有
    @Select("select * from usersites")
    List<UserSites> getSitesByMostClick();

    @Delete("delete from usersites where id=#{id}")
    int deleteSite(String id);

    @Select("select * from usersites where name like '%${0}%' " +
            " or url like '%${0}%'")
    List<UserSites> querySiteByParam(String param);
}
