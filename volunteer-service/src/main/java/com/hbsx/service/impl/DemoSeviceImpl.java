package com.hbsx.service.impl;

import com.hbsx.entity.Demo;
import com.hbsx.mappers.DemoMapper;
import com.hbsx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wangxiancheng
 * @Date 2019/9/11 17:49
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Service
public class DemoSeviceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public void insertData(Demo demo) {
        demoMapper.insertData(demo);
        //int a = 1/0;
    }
}
