package com.chenhao.mall.o2o.controller.person;

import com.chenhao.mall.o2o.pojo.ProductCategory;
import com.chenhao.mall.o2o.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/person/category")
public class PersonCategoryController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @GetMapping("/selectAll")
    private Map<String, Object> selectAllCategory() {
        Map<String, Object> map = new HashMap<>();
        List<ProductCategory> list = categoryService.selectAll();
        map.put("code", 0);
        map.put("data", list);
        return map;
    }
}
