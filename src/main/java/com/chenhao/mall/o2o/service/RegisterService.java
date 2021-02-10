package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.PersonInfo;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    int checkUserName(String userName);

    int createUser(PersonInfo personInfo);
}
