package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.HeadLineMapper;
import com.chenhao.mall.o2o.pojo.HeadLine;
import com.chenhao.mall.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineMapper headLineMapper;

    @Override
    public List<HeadLine> selectAll() {
        return headLineMapper.selectAll();
    }
}
