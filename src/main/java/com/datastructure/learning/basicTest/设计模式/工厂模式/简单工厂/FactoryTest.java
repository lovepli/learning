package com.datastructure.learning.basicTest.设计模式.工厂模式.简单工厂;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender s= factory.produce("mail");  //相当于  Sender s= new MailSender();
        s.send();

//        Sender s2= new MailSender();
//        s2.send();

        if(factory.produce("sms") instanceof Sender){ //首先判断是不是同一类型
            new SendFactory().produce("sms").send();
        }



//        if(s instanceof Sender){
//            System.out.println("s是 Sender类");
//        }
//
//        MailSender mailSender =new MailSender();
//        if(mailSender instanceof Sender){
//            System.out.println("mailSender 是 Sender的子类");
//
//        }

    }
}
