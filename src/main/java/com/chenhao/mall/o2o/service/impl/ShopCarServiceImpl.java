package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.ShopCarMapper;
import com.chenhao.mall.o2o.pojo.ShopCar;
import com.chenhao.mall.o2o.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public List<ShopCar> selectShopCarGoodList(int userId) {
        return shopCarMapper.selectShopCarGoodList(userId);
    }

    @Override
    public int insertGoods(Integer userId, Integer productId) {
        return shopCarMapper.insertGoods(userId, productId);
    }

    @Override
    public int selectByPrimaryKey(int userId, int productId) {
        return shopCarMapper.selectByPrimaryKey(userId, productId);
    }

    @Override
    public int addGoodsCount(int userId, int productId) {
        return shopCarMapper.addGoodsCount(userId, productId);
    }

    @Override
    public int updateGoodsCount(int userId, int productId, int count) {
        return shopCarMapper.updateGoodsCount(userId, productId, count);
    }

    @Override
    public int deleteGoods(int userId, int productId) {
        return shopCarMapper.deleteGoods(userId, productId);
    }
}
