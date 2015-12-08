package com.awbeci.dao;

import org.apache.ibatis.annotations.Param;
import com.awbeci.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    @ResultMap("com.awbeci.mapper.UserMapper.UserResult")
    List<User> selectUser();

    @Select("select * from user where name=#{name} and password=#{password}")
    User selectUserByParam(@Param("name") String name, @Param("password") String passwd);

    @Insert("insert into user(id,name,password,avatarUrl,niceName,email,emailAble,url,status,deleted,createDt,updateDt)" +
            "values(#{id},#{name},#{password},#{avatarUrl},#{niceName},#{email},#{emailAble},#{url},#{status},#{deleted},#{createDt},#{updateDt})")
    int insertUser(User user);
}
