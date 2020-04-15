package com.hbsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description 启动类
 * @Author wangxiancheng
 * @Date 2019/5/8 10:28
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@SpringBootApplication(scanBasePackages = "com.hbsx", exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
//@EnableApolloConfig
public class WebRunApplication {

    public static void main( String[] args ) {
        SpringApplication.run(WebRunApplication.class, args);
    }

}
