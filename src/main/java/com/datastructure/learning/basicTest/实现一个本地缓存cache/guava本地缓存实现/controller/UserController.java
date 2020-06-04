package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.controller;

import com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.entity.User;
import com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LJH
 * @date 2019/8/30-1:29
 * @QQ 1755497577     https://lijinhongpassion.github.io/codeant/ddcd.html
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("saveOrUpdate")
    public String saveOrUpdate(){
        userService.saveOrUpdate(new User(4L, "user4"));
        return "ok";
    }

    @GetMapping("get")
    public User get(Long id){
        return userService.get(id);
    }

    @GetMapping("delete")
    public String delete(Long id){
        userService.delete(id);
        return "d-ok";
    }

}
