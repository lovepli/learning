package com.datastructure.learning.basicTest.设计模式.建造者模式.demo1;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 建造者模式
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，
 * 所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的 Test 结合起来得到的。
 */
public class TestBuilder {
    public static void main(String[] args) {
         Builder builder = new Builder();
        builder.produceMailSender(10);

        }
}
