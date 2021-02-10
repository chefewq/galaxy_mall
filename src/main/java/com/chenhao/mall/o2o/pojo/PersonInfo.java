package com.chenhao.mall.o2o.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonInfo {
    private Integer userId;

    private String userName;

    private String password;

    private String profileImg;

    private String email;

    private String gender;

    private Integer enableStatus;

    private Integer userType;

    private Date creatTime;

    private Date lastEditTime;

}