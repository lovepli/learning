package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 某些热点数据在短时间内可能会被成千上万次访问，所以除了放在redis之外，还可以放在本地内存，也就是JVM的内存中。
 *
 * <p>我们可以使用google的guava cache组件实现本地缓存，之所以选择guava是因为它可以控制key和value的大小和超时时间，可以配置LRU策略且guava是线程安全的。
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        //缓存过期时间
                        expireAfterWrite(10, TimeUnit.SECONDS).
                        maximumSize(1000));
        return cacheManager;
    }
}
