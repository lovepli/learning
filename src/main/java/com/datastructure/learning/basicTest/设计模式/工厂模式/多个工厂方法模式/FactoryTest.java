package com.datastructure.learning.basicTest.设计模式.工厂模式.多个工厂方法模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:  多个工厂方法模式
 * 该模式是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而
 * 多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }
}

