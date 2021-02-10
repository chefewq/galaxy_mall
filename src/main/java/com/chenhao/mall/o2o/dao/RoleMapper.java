package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.authoritymanage.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper {
    Role selectById(Integer id);

    Role selectByName(String userName);
}
