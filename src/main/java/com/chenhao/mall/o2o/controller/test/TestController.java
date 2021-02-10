package com.chenhao.mall.o2o.controller.test;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/helloVue")
    private String helloVue(@RequestParam String param) {
        System.out.println(param);
        return "helloVue";
    }
}
