package com.awbeci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.awbeci.domain.Link;



/**
 * @author Siva
 *
 */
public interface ILinkDao
{
    @Select("select * from Link")
    @ResultMap("com.awbeci.mapper.LinkMapper.LinkResult")
    List<Link> selectLinkById();
}
