package com.chenhao.mall.o2o.dao;

import java.util.List;

public interface RoleAuthorityManageMapper {
    List<String> selectRoleAuthority(Integer userId);
}
