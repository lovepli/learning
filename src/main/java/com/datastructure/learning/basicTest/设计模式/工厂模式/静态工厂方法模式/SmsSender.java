package com.datastructure.learning.basicTest.设计模式.工厂模式.静态工厂方法模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is SMS sender!");
    }
}
