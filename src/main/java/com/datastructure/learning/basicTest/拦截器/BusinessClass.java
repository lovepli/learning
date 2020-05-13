package com.datastructure.learning.basicTest.拦截器;

/**
 * @author: lipan
 * @date: 2020-05-08
 * @description: 业务类
 */
public class BusinessClass implements BusinessInterface{

    public void doSomething() {
        System.out.println("业务组件BusinessClass方法调用:doSomething()");
    }
}
