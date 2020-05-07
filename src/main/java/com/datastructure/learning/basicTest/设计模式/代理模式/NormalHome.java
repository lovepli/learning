package com.datastructure.learning.basicTest.设计模式.代理模式;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 结婚家庭
 */
public class NormalHome implements ProxyInterface{

    @Override
    public void marry() {
        System.out.println("我们结婚啦～");
    }

}
