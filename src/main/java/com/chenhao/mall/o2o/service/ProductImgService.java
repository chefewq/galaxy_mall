package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.ProductImg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImgService {
    List<ProductImg> selectByProductId(Integer productId);
}
