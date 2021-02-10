package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PersonInfoMapper {
    PersonInfo Login(String userName, String password);

    int checkUserName(String userName);

    int insertUser(PersonInfo personInfo);
}