package com.chenhao.mall.o2o.controller.person;

import com.chenhao.mall.o2o.pojo.UserGoodsCollect;
import com.chenhao.mall.o2o.service.UserGoodsCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/person/goodsCollect")
public class UserGoodCollectController {
    @Autowired
    @Qualifier("userGoodsCollectServiceImpl")
    private UserGoodsCollectService goodsCollectService;

    @GetMapping("/selectAll")
    private Map<String, Object> selectAll(@RequestParam("userId") Integer userId) {
        Map<String, Object> map = new HashMap<>();
        List<UserGoodsCollect> list = new ArrayList<>();
        list = goodsCollectService.selectAll(userId);
        map.put("list", list);
        map.put("code", 0);
        map.put("msg", "获取商品收藏成功！");
        return map;
    }

    @GetMapping("/addGoods")
    private Map<String, Object> addGoods(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap<>();
        goodsCollectService.addGoods(userId, productId);
        map.put("code", 0);
        map.put("msg", "商品收藏成功！");
        return map;
    }

    @GetMapping("/deleteGoods")
    private Map<String, Object> deleteGoods(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap<>();
        goodsCollectService.deleteGoods(userId, productId);
        map.put("code", 0);
        map.put("msg", "商品已移除收藏！");
        return map;
    }
}
