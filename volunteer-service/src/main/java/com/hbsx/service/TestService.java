package com.hbsx.service;


import com.hbsx.entity.Demo;

/**
 * @Description TODO
 * @Author wangxiancheng
 * @Date 2019/9/11 17:59
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
public interface TestService {
    /**
     *  测试分布式事务
     * @Author wangxiancheng
     * @Date 2019/9/11 18:00
     * @param demo
     * @return
     **/
    void testDistributeTx(Demo demo);
}
