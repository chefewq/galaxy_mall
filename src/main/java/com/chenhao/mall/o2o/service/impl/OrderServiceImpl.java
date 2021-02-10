package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.OrderMapper;
import com.chenhao.mall.o2o.dao.ShopCarMapper;
import com.chenhao.mall.o2o.pojo.Order;
import com.chenhao.mall.o2o.pojo.OrderUtil;
import com.chenhao.mall.o2o.pojo.ShopCar;
import com.chenhao.mall.o2o.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public List<Order> selectAll(Integer userId) {
        return orderMapper.selectAll(userId);
    }

    @Override
    public int createOrder(OrderUtil orderUtil) {
        return orderMapper.createOrder(orderUtil);
    }

    @Override
    public int addOrder(Integer orderId, List<ShopCar> list) {
        return orderMapper.addOrder(orderId, list);
    }

    @Override
    public int deleteGoodsList(Integer userId, List<ShopCar> list) {
        return shopCarMapper.deleteGoodsList(userId, list);
    }
}
