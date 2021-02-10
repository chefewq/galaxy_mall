package com.chenhao.mall.o2o.service;

import com.chenhao.mall.o2o.pojo.HeadLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HeadLineService {
    List<HeadLine> selectAll();
}
