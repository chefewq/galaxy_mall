package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    List<Product> selectAll();

    List<Product> selectByCategoryId(Integer categoryId);

    List<Product> selectByGoodsName(String goodsName);

    int insertGoods(Product product);

    int updateGoodsImg(String img, Integer productId);

    Product selectByPrimaryKey(Integer productId);
}