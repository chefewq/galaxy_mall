package com.chenhao.mall.o2o.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class OrderElement {
    private Integer productId;

    private String productName;

    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private Integer productCategoryId;

    private Integer shopId;

    private String productTitle;

    Integer count;
}
