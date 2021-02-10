package com.chenhao.mall.o2o.controller.person;

import com.alibaba.fastjson.JSONObject;
import com.chenhao.mall.o2o.pojo.PersonInfo;
import com.chenhao.mall.o2o.pojo.User;
import com.chenhao.mall.o2o.pojo.UserInfo;
import com.chenhao.mall.o2o.service.LoginService;
import com.chenhao.mall.o2o.service.RegisterService;
import com.chenhao.mall.o2o.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/person")
public class PersonInfoController {
    @Autowired
    @Qualifier("registerServiceImpl")
    private RegisterService registerService;
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @PostMapping("/login")
    private Map<String, Object> userLogin(@RequestBody UserInfo userInfo) {
        User user = new User();
        Map<String, Object> map = new HashMap<>();
        PersonInfo personInfo = loginService.login(userInfo.getUsername(), userInfo.getPassword());
        if (personInfo != null) {
            user.setRole(loginService.selectRoleById(personInfo.getUserId()));
            user.setAuthority(loginService.selectByRoleId(user.getRole().getRoleId()));
            user.setPersonInfo(personInfo);
            String token = TokenUtil.sign(user);
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", token);
            data.put("UserInfo", personInfo);
            map.put("data", data);
            map.put("msg", "登录成功！");
            map.put("code", 0);
            return map;
        } else {
            map.put("msg", "用户名或密码错误");
            map.put("code", 3);
            return map;
        }
    }

    @PostMapping("/register/createUser")
    private Map<String, Object> UserRegister(@RequestBody String Data) {
        JSONObject data = JSONObject.parseObject(Data);
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserName(data.getString("userName"));
        personInfo.setPassword(data.getString("password"));
        registerService.createUser(personInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "注册成功!");
        return map;
    }

    @PostMapping("/register/checkUserName")
    private Map<String, Object> checkUserName(@RequestBody String userName) {
        Map<String, Object> map = new HashMap<>();
        JSONObject UserName = JSONObject.parseObject(userName);
        String username = UserName.getString("userName");
        if (registerService.checkUserName(username) == 1) {
            map.put("msg", "用户已存在");
            map.put("code", -1);
        } else {
            map.put("msg", "用户不存在");
            map.put("code", 0);
        }

        return map;
    }
}
