package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.AreaMapper;
import com.chenhao.mall.o2o.pojo.Area;
import com.chenhao.mall.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public int deleteByPrimaryKey(Integer areaId) {

        return areaMapper.deleteByPrimaryKey(areaId);
    }

    @Override
    public int insert(Area record) {
        return 0;
    }

    @Override
    public int insertSelective(Area record) {
        return 0;
    }

    @Override
    public Area selectByPrimaryKey(Integer areaId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Area record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Area record) {
        return 0;
    }

    @Override
    public List<Area> selectAll(String areaName) {
        return areaMapper.selectAll(areaName);
    }
}
