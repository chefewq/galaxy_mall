package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.ProductCategoryMapper;
import com.chenhao.mall.o2o.pojo.ProductCategory;
import com.chenhao.mall.o2o.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> selectAll() {

        return productCategoryMapper.selectAll();
    }
}
