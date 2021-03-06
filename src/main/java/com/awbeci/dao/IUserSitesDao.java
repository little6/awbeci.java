package com.awbeci.dao;

import com.awbeci.domain.User;
import com.awbeci.domain.UserSites;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("IUserSitesDao")
public interface IUserSitesDao {

    @Select("select * from usersites where categoryId=#{categoryId}")
    List<UserSites> getSiteByCategoryId(String categoryId);

    @Insert("insert into usersites(id,categoryId,uId,name,url,icon,sortno,createdt,updatedt)" +
            "values(#{id},#{categoryId},#{uId},#{name},#{url},#{icon},#{sortNo},#{createDt},#{updateDt})")
    int insertSite(UserSites userSites);

    @Update("update usersites set " +
            "categoryId=#{categoryId},uId=#{uId},name=#{name},url=#{url},icon=#{icon},sortno=#{sortNo},updatedt=#{updateDt} " +
            "where id=#{id}")
    int updateSite(UserSites userSites);

    //todo:根据点击次数>100查询数据，暂时先查询所有
    @Select("select * from usersites where uId=#{uId}")
    List<UserSites> getSitesByMostClick(String uId);

    @Delete("delete from usersites where id=#{id}")
    int deleteSite(String id);

    @Select("select * from usersites where name like '%${param}%'")
    List<UserSites> querySiteByParam(@Param("param")String param);
}
