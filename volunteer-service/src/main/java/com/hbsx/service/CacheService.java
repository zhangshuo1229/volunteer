package com.hbsx.service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description 缓存服务
 * @Author wangxiancheng
 * @Date 2019/6/3 14:31
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
public interface CacheService {

   /**
    *  根据key获取数据
    * @param key
    * @return
    **/
    Object getDataWithKey(String key);

    /**
     *  存储key,value,并设置时间
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     **/
    void setDataWithParams(String key, String value, long time, TimeUnit timeUnit);


    /**
     *  存储key,value
     * @param key
     * @param value
     * @return
     **/
    void setData(Object key, Object value);

    /**
     * 根据key删除数据
     * @param key
     * @return
     **/
    void delete(Object key);

    /**
     *  根据key设置过期时间
     * @param  key
     * @param  time
     * @param  timeUnit
     * @return boolean
     **/
    boolean expire(Object key, long time, TimeUnit timeUnit);


    /**
     *  存放集合类型得数据
     * @param key
     * @param collection
     * @return
     **/
    void rightPushAll(Object key, Collection collection);


   /**
    *  获取集合数据
    * @param key
    * @param start
    * @param end
    * @return List
    **/
    List range(Object key, long start, long end);
}
