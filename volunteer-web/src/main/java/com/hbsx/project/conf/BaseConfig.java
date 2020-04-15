package com.hbsx.project.conf;

import com.hbsx.common.base.mq.HbKafkaProducerServer;
import com.hbsx.common.base.utils.ZooKeeperSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

/**
 * @Description 基本配置
 * @Author wangxiancheng
 * @Date 2019/5/30 14:38
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Configuration
public class BaseConfig {

    @Value("${zookeeper.hosts}")
    private String zookeeperHost;
    @Value("${metadata.broker.list}")
    private String metadataBrokerList;
    @Value("${serializer.class}")
    private String serializerClass;
    @Value("${key.serializer.class}")
    private String keySerializerClass;
    @Value("${buffer.memory}")
    private String bufferMemory;
    @Value("${batch.size}")
    private String batchSize;
    @Value("${linger.ms}")
    private String lingerMs;
    @Value("${max.request.size}")
    private String maxRequestSize;
    @Value("${retries}")
    private String retries;
    @Value("${retry.backoff.ms}")
    private String retryBackoffMs;

    @Bean
    public ZooKeeperSession zooKeeperSession(){
        return new ZooKeeperSession(zookeeperHost);
    }

    /**
     * 生成restTemplate Bean
     *
     **/
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory simpleClientHttpRequestFactory){
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    @Bean
    public HbKafkaProducerServer hbKafkaProducerServer(){
        Properties props = new Properties();
        props.put("metadata.broker.list",metadataBrokerList);
        props.put("serializer.class", serializerClass);
        props.put("key.serializer.class", keySerializerClass);
        props.put("buffer.memory", bufferMemory);
        props.put("batch.size", batchSize);
        props.put("linger.ms", lingerMs);
        props.put("max.request.size", maxRequestSize);
        props.put("retries", retries);
        props.put("retry.backoff.ms", retryBackoffMs);
        return new HbKafkaProducerServer(props);
    }

    /**
     * restTemplate超时，连接相关配置
     *
     **/
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //单位为ms
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        return factory;
    }
}
