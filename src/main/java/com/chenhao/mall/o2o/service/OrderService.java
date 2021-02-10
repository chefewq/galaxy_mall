package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.Order;
import com.chenhao.mall.o2o.pojo.OrderUtil;
import com.chenhao.mall.o2o.pojo.ShopCar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> selectAll(Integer userId);

    int createOrder(OrderUtil orderUtil);

    int addOrder(Integer orderId, List<ShopCar> list);

    int deleteGoodsList(Integer userId, List<ShopCar> list);
}
