package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductCategoryMapper {
    List<ProductCategory> selectAll();
}