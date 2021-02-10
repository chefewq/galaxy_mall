package com.chenhao.mall.o2o;

import com.chenhao.mall.o2o.dao.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class O2oMall2ApplicationTests {

    //    @Autowired
//    AuthorityMapper authorityMapper;
//    @Autowired
//    RoleMapper roleMapper;
    @Autowired
    OrderMapper orderMapper;

    @Test
    void contextLoads() {

        System.out.println(orderMapper.selectAll(1));
    }

}
