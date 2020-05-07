package com.datastructure.learning.basicTest.设计模式.工厂模式.抽象工厂模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 抽象工厂模式
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修
 * 改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂
 * 类，这样一旦需要增加新的功能， 直接增加新的工厂类就可以了，不需要修改之前的代码。
 *
 * 核心：定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }


}
