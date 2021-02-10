package com.chenhao.mall.o2o.controller.person;

import com.chenhao.mall.o2o.pojo.ShopCar;
import com.chenhao.mall.o2o.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/person/shopCar")
public class ShopCarController {
    @Autowired
    @Qualifier("shopCarServiceImpl")
    private ShopCarService shopCarService;

    @GetMapping("/selectShopCarGoodList")
    private Map<String, Object> selectShopCarGoodList(@RequestParam("userId") Integer userId) {
        Map<String, Object> map = new HashMap<>();
        List<ShopCar> list = shopCarService.selectShopCarGoodList(userId);
        map.put("list", list);
        map.put("code", 0);
        return map;
    }

    @GetMapping("/addGoods")
    private Map<String, Object> addGoods(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap<>();
        if (shopCarService.selectByPrimaryKey(userId, productId) == 1) {
            shopCarService.addGoodsCount(userId, productId);
            map.put("code", 3);
            map.put("msg", "商品已存在！数量加一");
        } else {
            shopCarService.insertGoods(userId, productId);
            map.put("code", 0);
            map.put("msg", "添加购物车成功！");
        }
        return map;
    }

    @GetMapping("/updateGoodsCount")
    private Map<String, Object> updateGoodCount(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        Map<String, Object> map = new HashMap();
        shopCarService.updateGoodsCount(userId, productId, count);
        map.put("msg", "更新成功!");
        map.put("code", 0);
        return map;
    }

    @GetMapping("/deleteGoods")
    private Map<String, Object> deleteGoods(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap();
        shopCarService.deleteGoods(userId, productId);
        map.put("msg", "商品已成功从购物车移除！");
        map.put("code", 0);
        return map;
    }
}
