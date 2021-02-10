package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.UserGoodsCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserGoodsCollectMapper {
    List<UserGoodsCollect> selectAll(Integer userId);

    int addGoods(Integer userId, Integer productId);

    int deleteGoods(Integer userId, Integer productId);
}
