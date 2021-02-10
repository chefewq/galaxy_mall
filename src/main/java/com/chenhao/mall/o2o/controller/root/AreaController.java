package com.chenhao.mall.o2o.controller.root;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.chenhao.mall.o2o.pojo.area.ListQuery;
import com.chenhao.mall.o2o.service.AreaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/area")
public class AreaController {
    @Autowired
    @Qualifier("areaServiceImpl")
    private AreaService areaService;

    @GetMapping("/getarealist")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Map<String, Object> getAreaList(@RequestParam("query") String list) throws JsonProcessingException {
        JSONObject listQuery = JSONObject.parseObject(list);
        ListQuery query = new ListQuery(listQuery.getString("title"), listQuery.getInteger("page"), listQuery.getInteger("limit"));
        PageHelper.startPage(query.getPage(), query.getLimit());
        PageInfo pageInfo = new PageInfo(areaService.selectAll("%" + query.getTitle() + "%"));
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        map.put("data", pageInfo);
        map.put("code", 0);
        return map;
    }

    @GetMapping("/deletearea")
    private Map<String, Object> deleteAreaById(@RequestParam("param") String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            areaService.deleteByPrimaryKey(Integer.parseInt(id));
        } catch (Exception e) {
            map.put("code", -1);
            return map;
        }
        map.put("code", 0);
        return map;
    }
}
