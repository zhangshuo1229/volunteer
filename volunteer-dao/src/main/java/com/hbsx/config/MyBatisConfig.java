package com.hbsx.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.github.pagehelper.PageHelper;
import com.hbsx.config.DataBaseProperties;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description MyBatis配置类
 * @Author wangxiancheng
 * @Date 2019/5/8 9:47
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Configuration
@Slf4j
@MapperScan(value = "com.hbsx.mappers", sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfig{

    @Resource
    private DataBaseProperties dataBaseProperties;

    /**
    * @Description: 数据源配置
    * @param:
    * @return:
    **/
    @Bean(name = "realDataSource")
    @Primary
    DataSource realDataSource() throws SQLException {

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataBaseProperties.getUrl());
        datasource.setDriverClassName(dataBaseProperties.getDriverClassName());
        datasource.setUsername(dataBaseProperties.getUsername());
        datasource.setPassword(dataBaseProperties.getPassword());
        datasource.setMaxActive(dataBaseProperties.getMaxActive());
        datasource.setFilters("stat");
        return datasource;
    }

    @Bean(name = "dataSourceProxy")
    public DataSourceProxy dataSourceProxy(DataSource realDataSource) {
        return new DataSourceProxy(realDataSource);
    }


    /**
     * @Description: 事务配置
     * @param:
     * @return:
     **/
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(DataSourceProxy dataSourceProxy) {
        try {
            return new DataSourceTransactionManager(dataSourceProxy);
        } catch (Exception e) {
            log.error("annotationDrivenTransactionManager has exception", e);
        }
        return null;
    }

    /**
    * @Description: sessionFactory 配置
    * @param:
    * @return:
    **/
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(DataSourceProxy dataSourceProxy) throws SQLException {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceProxy);
        factoryBean.setTypeAliasesPackage(
            "com.hbsx.entity");

        factoryBean.setPlugins(new Interceptor[]{pageHelper()});

        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            factoryBean.setMapperLocations(
                resolver.getResources("classpath*:/META-INF/mybatis/ft/*.xml"));
            factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
            return factoryBean.getObject();
        } catch (Exception e) {
            log.error("getSqlSessionFactory failed, errorMessage:{}", e);
            throw new RuntimeException(e);
        }

    }


    /**
    * @Description: 分页插件
    * @param:
    * @return:
    *
    **/
    public Interceptor pageHelper() {

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
