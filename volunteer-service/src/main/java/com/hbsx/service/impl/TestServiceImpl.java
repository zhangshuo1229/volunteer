package com.hbsx.service.impl;

import com.hbsx.entity.Demo;
import com.hbsx.service.DemoService;
import com.hbsx.service.TestService;
import com.hbsx.ucenter.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wangxiancheng
 * @Date 2019/9/11 17:59
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Service
public class TestServiceImpl implements TestService {


    @Resource
    private UserService userService;
    @Autowired
    private DemoService demoService;

    /**
     *  分布式事务只需要加该注解
     * @Author wangxiancheng
     * @Date 2019/9/11 18:10
     * @param
     * @return
     **/
    @GlobalTransactional
    @Override
    public void testDistributeTx(Demo demo) {

        demoService.insertData(demo);
        System.out.println("分布式事务执行完毕");
    }
}
