package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<ProductCategory> selectAll();
}
