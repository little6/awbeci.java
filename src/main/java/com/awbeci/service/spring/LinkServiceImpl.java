package com.awbeci.service.spring;
import java.util.List;

import com.awbeci.dao.ILinkDao;
import com.awbeci.domain.Link;
import com.awbeci.service.ILinkService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    private ILinkDao linkDao;

    @Override
    public List<Link> selectLinkById() {
        return linkDao.selectLinkById();
    }
}
