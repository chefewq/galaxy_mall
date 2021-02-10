package com.chenhao.mall.o2o.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCar {
    private Integer productId;

    private String productName;

    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;

    private Date creatTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private Integer productCategoryId;

    private Integer shopId;

    private String productTitle;

    int count;

    boolean check;
}
