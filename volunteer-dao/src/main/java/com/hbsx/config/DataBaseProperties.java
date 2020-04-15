package com.hbsx.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 数据库连接信息类
 * @Author wangxiancheng
 * @Date 2019/5/8 9:47
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Data
@Configuration
public class DataBaseProperties {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.maxActive}")
    private int maxActive;

}
