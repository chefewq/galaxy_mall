package com.chenhao.mall.o2o.service.impl;

import com.chenhao.mall.o2o.dao.PersonInfoMapper;
import com.chenhao.mall.o2o.pojo.PersonInfo;
import com.chenhao.mall.o2o.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public int checkUserName(String userName) {
        return personInfoMapper.checkUserName(userName);
    }

    @Override
    public int createUser(PersonInfo personInfo) {
        return personInfoMapper.insertUser(personInfo);
    }
}
