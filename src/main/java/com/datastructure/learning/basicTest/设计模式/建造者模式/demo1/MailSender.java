package com.datastructure.learning.basicTest.设计模式.建造者模式.demo1;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mail sender!");
    }

}
