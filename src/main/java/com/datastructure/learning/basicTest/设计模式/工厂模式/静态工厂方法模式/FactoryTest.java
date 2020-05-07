package com.datastructure.learning.basicTest.设计模式.工厂模式.静态工厂方法模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:  静态工厂方法模式
 * 将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 */
public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }
}

