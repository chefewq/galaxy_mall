package com.chenhao.mall.o2o.controller.person;


import com.chenhao.mall.o2o.pojo.AddOrder;
import com.chenhao.mall.o2o.pojo.Order;
import com.chenhao.mall.o2o.pojo.OrderUtil;
import com.chenhao.mall.o2o.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/person/order")
public class OrderController {
    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    @GetMapping("/selectAll")
    private Map<String, Object> selectAll(@RequestParam("userId") Integer userId) {
        Map<String, Object> map = new HashMap<>();
        List<Order> list = new ArrayList<>();
        list = orderService.selectAll(userId);
        map.put("list", list);
        map.put("msg", "查找订单成功");
        map.put("code", 0);
        return map;
    }

    @PostMapping("/addOrder")
    private Map<String, Object> addOrder(@RequestBody AddOrder addOrder) {
        Map<String, Object> map = new HashMap<>();

        OrderUtil orderUtil = new OrderUtil();
        orderUtil.setUserId(addOrder.getUserId());
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderUtil.setCreateTime(new java.sql.Date(date.getTime()));
        orderService.createOrder(orderUtil);
        orderService.addOrder(orderUtil.getOrderId(), addOrder.getProducts());
        orderService.deleteGoodsList(addOrder.getUserId(), addOrder.getProducts());
        map.put("msg", "购买成功！");
        map.put("code", 0);
        return map;
    }
}
