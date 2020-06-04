package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.demo2;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author: lipan
 * @date: 2020/6/4
 * @description:
 */
@Service
public class CacheServiceImpl implements CacheService {

    private Cache<String,Object> commonCache=null;


    @PostConstruct
    public void init(){
        commonCache= CacheBuilder.newBuilder()
                //缓存初始容量10
                .initialCapacity(10)
                //最多100个key，超过按LRU策略移除
                .maximumSize(100)
                //写入后多少秒过期
                .expireAfterWrite(60, TimeUnit.SECONDS).build();
    }
    @Override
    public void setCommonCache(String key, Object value) {
        commonCache.put(key,value);
    }

    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }
}
