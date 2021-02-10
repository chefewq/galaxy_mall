package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.UserGoodsCollect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserGoodsCollectService {
    List<UserGoodsCollect> selectAll(Integer userId);

    int addGoods(Integer userId, Integer productId);

    int deleteGoods(Integer userId, Integer productId);
}
