package com.chenhao.mall.o2o.pojo;

import com.chenhao.mall.o2o.pojo.authoritymanage.Authority;
import com.chenhao.mall.o2o.pojo.authoritymanage.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private PersonInfo personInfo;
    private Role role;
    private List<Authority> authority;
}
