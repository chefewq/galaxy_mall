package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.UserGoodsCollectMapper;
import com.chenhao.mall.o2o.pojo.UserGoodsCollect;
import com.chenhao.mall.o2o.service.UserGoodsCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGoodsCollectServiceImpl implements UserGoodsCollectService {
    @Autowired
    private UserGoodsCollectMapper userGoodsCollectMapper;

    @Override
    public List<UserGoodsCollect> selectAll(Integer userId) {
        return userGoodsCollectMapper.selectAll(userId);
    }

    @Override
    public int addGoods(Integer userId, Integer productId) {
        return userGoodsCollectMapper.addGoods(userId, productId);
    }

    @Override
    public int deleteGoods(Integer userId, Integer productId) {
        return userGoodsCollectMapper.deleteGoods(userId, productId);
    }
}
