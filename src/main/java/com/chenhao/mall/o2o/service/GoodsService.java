package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    PageInfo selectAll(int currentSize, int pageSize);

    PageInfo selectByCategoryId(int categoryId, int currentPage, int pageSize);

    PageInfo selectByName(String goodsName, int currentPage, int pageSize);

    Integer insetGoods(Product product);

    Integer updateGoodsImg(String img, Integer productId);

    Product selectByPrimaryKey(Integer productId);

    List<Product> selectByCategoryId(int categoryId);
}
