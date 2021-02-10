package com.chenhao.mall.o2o.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrder {
    List<ShopCar> products;
    Integer userId;
}
