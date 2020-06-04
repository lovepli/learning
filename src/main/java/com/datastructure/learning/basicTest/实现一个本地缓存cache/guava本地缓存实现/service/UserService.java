package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.service;

import com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.entity.User;

/**
 * <p>
 * UserService
 * </p>
 *
 * @package: com.example.li.springboot_cache_redis_demo.service
 * @description: UserService
 * @author: LJH
 */
public interface UserService {
    /**
     * 保存或修改用户
     *
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrUpdate(User user);

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    User get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);
}
