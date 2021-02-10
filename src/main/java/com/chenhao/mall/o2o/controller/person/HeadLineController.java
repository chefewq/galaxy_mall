package com.chenhao.mall.o2o.controller.person;

import com.chenhao.mall.o2o.pojo.HeadLine;
import com.chenhao.mall.o2o.service.HeadLineService;
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
@RequestMapping("/person/goods/headline")
public class HeadLineController {
    @Autowired
    @Qualifier("headLineServiceImpl")
    private HeadLineService headLineService;

    @GetMapping("/selectAll")
    private Map<String, Object> selectAll() {
        Map<String, Object> map = new HashMap<>();
        List<HeadLine> list = headLineService.selectAll();
        map.put("list", list);
        map.put("code", 0);
        return map;
    }
}
