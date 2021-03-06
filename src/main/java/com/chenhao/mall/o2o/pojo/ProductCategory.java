package com.chenhao.mall.o2o.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    private Integer productCategoryId;

    private Integer shopId;

    private String productCategoryName;

    private Integer priority;

    private Date createTime;

}