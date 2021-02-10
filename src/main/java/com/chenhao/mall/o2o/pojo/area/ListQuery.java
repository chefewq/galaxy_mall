package com.chenhao.mall.o2o.pojo.area;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListQuery {
    private String title;
    private Integer page;
    private Integer limit;

}
