package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopCarMapper {
    List<ShopCar> selectShopCarGoodList(int userId);

    int insertGoods(int userId, int productId);

    int selectByPrimaryKey(int userId, int productId);

    int addGoodsCount(int userId, int productId);

    int updateGoodsCount(int userId, int productId, int count);

    int deleteGoods(int userId, int productId);

    int deleteGoodsList(int userId, List<ShopCar> list);
}
