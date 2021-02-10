package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> selectAll(String areaName);
}
