package com.hbsx.mappers;

import com.hbsx.entity.Demo;
import org.springframework.stereotype.Repository;

/**
 * @Description 测试用户mapper
 * @Author wangxiancheng
 * @Date 2019/5/8 9:55
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Repository
public interface DemoMapper {

    /**
     *  插入数据
     * @Author wangxiancheng
     * @Date 2019/9/11 17:50
     * @param demo
     * @return
     **/
    void insertData(Demo demo);
}
