package com.chenhao.mall.o2o.dao;

import com.chenhao.mall.o2o.pojo.authoritymanage.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthorityMapper {
    List<Authority> selectByRoleID(Integer roleId);
}
