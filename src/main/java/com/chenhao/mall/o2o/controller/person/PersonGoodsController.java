package com.chenhao.mall.o2o.controller.person;

import com.chenhao.mall.o2o.pojo.Product;
import com.chenhao.mall.o2o.pojo.ProductImg;
import com.chenhao.mall.o2o.service.GoodsService;
import com.chenhao.mall.o2o.service.ProductImgService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/person/goods")
public class PersonGoodsController {

    @Autowired
    @Qualifier("goodsServiceImpl")
    private GoodsService goodsService;
    @Autowired
    @Qualifier("productImgServiceImpl")
    private ProductImgService productImgService;

    @GetMapping("/list")
    private Map<String, Object> selectGoods(@Param("categoryID") String categoryID,
                                            @Param("currentPage") String currentPage,
                                            @Param("pageSize") String pageSize) {
        Map<String, Object> map = new HashMap<>();
        Integer categoryId = null;
        Integer CurrentPage = null;
        Integer PageSize = null;
        if (categoryID != null) {
            categoryId = Integer.parseInt(categoryID);
        }
        if (currentPage != null) {
            CurrentPage = Integer.parseInt(currentPage);
        }
        if (pageSize != null) {
            PageSize = Integer.parseInt(pageSize);
        }
        if (categoryID == null && CurrentPage != null && PageSize != null) {
            // System.out.println(CurrentPage);
            PageInfo pageInfo = goodsService.selectAll(CurrentPage, PageSize);
            map.put("data", pageInfo);
        }
        if (categoryID != null && CurrentPage != null && PageSize != null) {
            PageInfo pageInfo = goodsService.selectByCategoryId(categoryId, CurrentPage, PageSize);
            map.put("data", pageInfo);
        }
        map.put("code", 0);
        return map;
    }

    @GetMapping("/searchByName")
    private Map<String, Object> searchGoodsByName(@Param("search") String search,
                                                  @Param("currentPage") String currentPage,
                                                  @Param("pageSize") String pageSize) {
        Map<String, Object> map = new HashMap<>();
        String goodsName = null;
        Integer CurrentPage = null;
        Integer PageSize = null;
        if (currentPage != null) {
            CurrentPage = Integer.parseInt(currentPage);
        }
        if (pageSize != null) {
            PageSize = Integer.parseInt(pageSize);
        }
        goodsName = "%" + search + "%";
        if (CurrentPage != null && PageSize != null) {
            PageInfo pageInfo = goodsService.selectByName(goodsName, CurrentPage, PageSize);
            map.put("data", pageInfo);
        }
        map.put("code", 0);
        return map;
    }

    @GetMapping("/getDetails")
    private Map<String, Object> getDetails(@RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap<>();
        List<Product> list = new ArrayList<>();
        list.add(goodsService.selectByPrimaryKey(productId));
        map.put("list", list);
        map.put("code", 0);
        return map;
    }

    @GetMapping("/getPictureDetails")
    private Map<String, Object> getPictureDetails(@RequestParam("productId") Integer productId) {
        Map<String, Object> map = new HashMap<>();
        List<ProductImg> list = new ArrayList<>();
        list = productImgService.selectByProductId(productId);
        map.put("list", list);
        map.put("code", 0);
        return map;
    }

    @GetMapping("/getPromoProduct")
    private Map<String, Object> getGoodsCategoryList(@RequestParam("categoryName") Integer categoryName) {
        Map<String, Object> map = new HashMap<>();
        List<Product> list = new ArrayList<>();
        switch (categoryName) {
            case 1:
                list = goodsService.selectByCategoryId(1).subList(0, 7);
                break;
            case 2:
                list = goodsService.selectByCategoryId(2).subList(0, 7);
                break;
            case 3:
                list = goodsService.selectByCategoryId(5);
                break;
            case 4:
                list = goodsService.selectByCategoryId(7);
                break;
            case 5:
                list = goodsService.selectByCategoryId(3).subList(0, 2);
                list.addAll(goodsService.selectByCategoryId(2).subList(0, 4));
                list.addAll(goodsService.selectByCategoryId(4).subList(0, 1));
                ;
                break;
            case 6:
                list = goodsService.selectByCategoryId(5).subList(0, 3);
                list.addAll(goodsService.selectByCategoryId(7).subList(0, 2));
                list.addAll(goodsService.selectByCategoryId(8).subList(0, 2));
                break;
        }
        map.put("list", list);
        map.put("code", 0);
        return map;
    }
}
