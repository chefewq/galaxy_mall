package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.ProductMapper;
import com.chenhao.mall.o2o.pojo.Product;
import com.chenhao.mall.o2o.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo selectAll(int currentSize, int pageSize) {
        PageHelper.startPage(currentSize, pageSize);
        PageInfo pageInfo = new PageInfo(productMapper.selectAll());
        return pageInfo;
    }

    @Override
    public PageInfo selectByCategoryId(int categoryId, int currentSize, int pageSize) {
        PageHelper.startPage(currentSize, pageSize);
        PageInfo pageInfo = new PageInfo(productMapper.selectByCategoryId(categoryId));
        return pageInfo;
    }

    @Override
    public PageInfo selectByName(String goodsName, int currentSize, int pageSize) {
        PageHelper.startPage(currentSize, pageSize);
        PageInfo pageInfo = new PageInfo(productMapper.selectByGoodsName(goodsName));
        return pageInfo;
    }

    @Override
    public Integer insetGoods(Product product) {
        return productMapper.insertGoods(product);
    }

    @Override
    public Integer updateGoodsImg(String img, Integer productId) {
        return productMapper.updateGoodsImg(img, productId);
    }

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectByCategoryId(int categoryId) {
        return productMapper.selectByCategoryId(categoryId);
    }
}
