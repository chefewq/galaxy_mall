package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.Order;
import com.chenhao.mall.o2o.pojo.OrderUtil;
import com.chenhao.mall.o2o.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> selectAll(int userId);

    int createOrder(OrderUtil orderUtil);

    int addOrder(int orderId, List<ShopCar> list);
}
