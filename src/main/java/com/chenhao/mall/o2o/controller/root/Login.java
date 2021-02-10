package com.chenhao.mall.o2o.controller.root;


import com.chenhao.mall.o2o.pojo.PersonInfo;
import com.chenhao.mall.o2o.pojo.User;
import com.chenhao.mall.o2o.pojo.UserInfo;
import com.chenhao.mall.o2o.service.LoginService;
import com.chenhao.mall.o2o.util.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("*")
public class Login {

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginService loginService;

    @PostMapping("/user/login")
    private String toLogin(@RequestBody UserInfo userInfo) throws JsonProcessingException {
        User user = new User();
        HashMap<String, Object> hs = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        PersonInfo userInfo1 = loginService.login(userInfo.getUsername(), userInfo.getPassword());
        if (userInfo1 != null) {
            user.setPersonInfo(userInfo1);
            user.setRole(loginService.selectRoleById(user.getPersonInfo().getUserId()));
            user.setAuthority(loginService.selectByRoleId(user.getRole().getRoleId()));
            String token = TokenUtil.sign(user);
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", token);
            hs.put("data", data);
            hs.put("code", 0);
            hs.put("msg", "登录成功");
        } else {
            hs.put("code", -1);
            hs.put("msg", "密码或账号错误！");
        }
        return objectMapper.writeValueAsString(hs);
    }

    @GetMapping("/user/info")
    private String getInfo(@Param("token") String token) throws JsonProcessingException {
        HashMap<String, Object> hs = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        boolean boll = TokenUtil.verify(token);
        if (boll != true) {
            hs.put("code", 50008);
        } else {
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", TokenUtil.getUsername(token));
            data.put("roles", loginService.selectRoleByRoleName(TokenUtil.getUsername(token)).getRoleName());
            hs.put("data", data);
            hs.put("code", 0);
        }
        return objectMapper.writeValueAsString(hs);
    }
}
