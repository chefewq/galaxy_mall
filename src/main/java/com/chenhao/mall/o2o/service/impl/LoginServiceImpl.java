package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.AuthorityMapper;
import com.chenhao.mall.o2o.dao.PersonInfoMapper;
import com.chenhao.mall.o2o.dao.RoleMapper;
import com.chenhao.mall.o2o.pojo.PersonInfo;
import com.chenhao.mall.o2o.pojo.authoritymanage.Authority;
import com.chenhao.mall.o2o.pojo.authoritymanage.Role;
import com.chenhao.mall.o2o.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public PersonInfo login(String userName, String password) {
        PersonInfo user = personInfoMapper.Login(userName, password);
        if (user != null) {

            return user;
        }
        return null;
    }

    @Override
    public Role selectRoleById(Integer user_id) {
        return roleMapper.selectById(user_id);
    }

    @Override
    public List<Authority> selectByRoleId(Integer roleId) {
        return authorityMapper.selectByRoleID(roleId);
    }

    @Override
    public Role selectRoleByRoleName(String userName) {
        return roleMapper.selectByName(userName);
    }
}
