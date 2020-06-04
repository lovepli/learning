package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.demo2;

/**
 * @author: lipan
 * @date: 2020/6/4
 * @description:
 */
public interface CacheService {

    //存方法
    void setCommonCache(String key,Object value);
    //取方法
    Object getFromCommonCache(String key);
}
