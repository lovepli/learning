package com.datastructure.learning.basicTest.设计模式.工厂模式.多个工厂方法模式;


/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 多个工厂方法模式
 */
public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}



