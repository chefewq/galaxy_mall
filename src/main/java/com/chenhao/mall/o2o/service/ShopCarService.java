package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.ShopCar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopCarService {
    List<ShopCar> selectShopCarGoodList(int userId);

    int insertGoods(Integer userId, Integer productId);

    int selectByPrimaryKey(int userId, int productId);

    int addGoodsCount(int userId, int productId);

    int updateGoodsCount(int userId, int productId, int count);

    int deleteGoods(int userId, int productId);
}
