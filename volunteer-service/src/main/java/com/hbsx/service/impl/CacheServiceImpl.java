package com.hbsx.service.impl;

import com.hbsx.common.base.pub.ErrorCode;
import com.hbsx.common.base.pub.HbsxException;
import com.hbsx.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description 缓存服务实现类
 * @Author wangxiancheng
 * @Date 2019/6/3 14:42
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  根据key获取数据
     * @Author wangxiancheng
     * @Date 2019/6/3 14:44
     * @param key
     * @return Object
     **/
    @Override
    public Object getDataWithKey(String key) {
        try {
            return  redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            log.error("getDataWithKey is error:{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"根据key获取redis异常");
        }
    }

    /**
     *  存储key,value,并设置时间
     * @Author wangxiancheng
     * @Date 2019/6/3 14:45
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     **/
    @Override
    public void setDataWithParams(String key, String value, long time, TimeUnit timeUnit) {

        try {

            redisTemplate.opsForValue().set(key, value, time, timeUnit);
        }catch (Exception e){
            log.error("setDataWithParams is error{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis根据时间存储异常");
        }

    }

   /**
    *  存储key,value
    * @Author wangxiancheng
    * @Date 2019/6/3 14:45
    * @param key
    * @param value
    * @return
    **/
    @Override
    public void setData(Object key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        }catch (Exception e){
            log.error("setData is error{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis存储异常");
        }
    }

    /**
     *  根据key删除数据
     * @Author wangxiancheng
     * @Date 2019/6/3 14:46
     * @param key
     * @return
     **/
    @Override
    public void delete(Object key) {

        try {
            redisTemplate.delete(key);
        }catch (Exception e){
            log.error("setData is error{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis根据删除异常");
        }
    }

    /**
     *  根据key设置过期时间
     * @Author wangxiancheng
     * @Date 2019/6/3 14:46
     * @param key
     * @param time
     * @param timeUnit
     * @return
     **/
    @Override
    public boolean expire(Object key, long time, TimeUnit timeUnit) {
        try {
            return redisTemplate.expire(key, time, timeUnit);
        }catch (Exception e){
            log.error("expire is error{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis设置过期时间异常");
        }
    }


   /**
    * 存放集合类型得数据
    * @Author wangxiancheng
    * @Date 2019/6/3 14:46
    * @param key
    * @param collection
    * @return
    **/
    @Override
    public void rightPushAll(Object key, Collection collection) {
        try {
            redisTemplate.opsForList().rightPushAll(key,collection);
        }catch (Exception e){
            log.error("rightPushAll is error{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis存放集合数据异常");
        }
    }

    /**
     * 获取集合数据
     * @Author wangxiancheng
     * @Date 2019/6/3 14:46
     * @param key
     * @param start
     * @param end
     * @return List
     **/
    @Override
    public List range(Object key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key,start,end);
        }catch (Exception e){
            log.error("rightPushAll is error:{}",e);
            throw new HbsxException(ErrorCode.ERROR_SELF.getCode(),"redis获取集合数据异常");
        }
    }
}
