package com.datastructure.learning.basicTest.设计模式.工厂模式.抽象工厂模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: SendSms工厂类
 */
public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
