package com.datastructure.learning.basicTest.设计模式.建造者模式.链式;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  参考https://www.jianshu.com/p/8e871becd9cf
 */
public class Test {

    public static void main(String[] args) {
        User user = new User.Builder().id("1")
                .name("张三")
                .password("123456")
                .phone("15820638007").build();
        System.out.println(user.toString());
    }

    /**
     * 重点(相比于普通JavaBean的好处)：
     * 在建造者模式中,提供一个辅助的静态建造器Builder(静态内部类),可以在里面set实体类的属性,
     * 与JavaBean不同的是,建造者是先set,在通过build实例化实体类,这样既可以提高代码的阅读性,
     * 也可以防止对象没有实例化,就被调用;不会造成不一致性,同时解决了Javabean模式的线程安全问题
     *
     */
}
