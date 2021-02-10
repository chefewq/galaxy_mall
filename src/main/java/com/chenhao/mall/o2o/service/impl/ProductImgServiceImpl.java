package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.ProductImgMapper;
import com.chenhao.mall.o2o.pojo.ProductImg;
import com.chenhao.mall.o2o.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    ProductImgMapper productImgMapper;

    @Override
    public List<ProductImg> selectByProductId(Integer productId) {
        return productImgMapper.selectByProductId(productId);
    }
}
