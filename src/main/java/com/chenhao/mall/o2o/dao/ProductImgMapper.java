package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.ProductImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductImgMapper {
    List<ProductImg> selectByProductId(Integer productId);
}