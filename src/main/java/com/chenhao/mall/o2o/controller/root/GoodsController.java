package com.chenhao.mall.o2o.controller.root;

import com.alibaba.fastjson.JSONObject;
import com.chenhao.mall.o2o.pojo.Product;
import com.chenhao.mall.o2o.pojo.ProductCategory;
import com.chenhao.mall.o2o.service.CategoryService;
import com.chenhao.mall.o2o.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;
    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;

    @GetMapping("/getGoodsCategoryList")
    private Map<String, Object> selectGoodsCategoryList() {
        Map<String, Object> map = new HashMap<>();
        List<ProductCategory> list;
        list = categoryService.selectAll();
        map.put("list", list);
        map.put("code", 0);
        return map;
    }

    @PostMapping("/insertGoods")
    private Map<String, Object> insertGoods(@RequestParam("goods") String goods, @RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();
        JSONObject good = JSONObject.parseObject(goods);
        Product product = new Product();
        product.setProductName(good.getString("name"));
        product.setProductCategoryId(good.getInteger("region"));
        product.setProductTitle(good.getString("title"));
        product.setNormalPrice(good.getString("normalPrice"));
        product.setPromotionPrice(good.getString("promotePrice"));
        product.setShopId(1);
        product.setPriority(1);
        product.setEnableStatus(1);
        goodsService.insetGoods(product);
        if (file.getSize() / 1000 > 500) {
            map.put("msg", "图片大小不能超过500kb");
            map.put("code", -1);
            return map;
        }

        InputStream in = file.getInputStream();
        File mkdir = new File("F://galaxy/img/" + product.getProductId());
        if (!mkdir.exists()) {
            mkdir.mkdirs();
        }
        FileOutputStream os = new FileOutputStream(mkdir.getPath() + "\\" + product.getProductId() + ".jpg");
        int len = 0;
        while ((len = in.read()) != -1) {
            os.write(len);
        }
        os.flush();
        in.close();
        os.close();
        goodsService.updateGoodsImg("" + product.getProductId() + "/" + product.getProductId() + ".jpg", product.getProductId());
        map.put("code", 0);
        map.put("msg", "商品添加成功");
        return map;
    }
}
