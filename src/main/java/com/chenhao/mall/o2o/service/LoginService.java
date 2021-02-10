package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.PersonInfo;
import com.chenhao.mall.o2o.pojo.authoritymanage.Authority;
import com.chenhao.mall.o2o.pojo.authoritymanage.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    PersonInfo login(String username, String password);

    Role selectRoleById(Integer userId);

    List<Authority> selectByRoleId(Integer roleId);

    Role selectRoleByRoleName(String userName);
}
