package com.hbsx.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MapperScanner配置类 注意，由于MapperScannerConfig执行的比较早，所以必须有下面的注解
 * @Author wangxiancheng
 * @Date 2019/5/8 9:47
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Configuration
@AutoConfigureAfter(com.hbsx.config.MyBatisConfig.class)
public class MapperScannerConfig {

    /**
    * @Description: MapperScanner 配置
    * @return:
    *
    **/
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.hbsx.mappers");
        return mapperScannerConfigurer;
    }

}
