package com.awbeci.service;

import java.util.List;

import com.awbeci.domain.Link;
import com.awbeci.mapper.LinkMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LinkService {
    @Autowired
    private SqlSession sqlSession;

    private LinkMapper getLinkMapper() {
        return sqlSession.getMapper(LinkMapper.class);
    }

    public List<Link> selectLinkById() {
        return getLinkMapper().selectLinkById(1);
    }

}
