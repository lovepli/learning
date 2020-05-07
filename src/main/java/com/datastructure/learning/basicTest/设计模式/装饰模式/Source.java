package com.datastructure.learning.basicTest.设计模式.装饰模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description: 被装饰者
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
