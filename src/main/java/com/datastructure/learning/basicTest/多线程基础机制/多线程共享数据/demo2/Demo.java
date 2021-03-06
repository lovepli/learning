package com.datastructure.learning.basicTest.多线程基础机制.多线程共享数据.demo2;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class Demo {

    /**
     * 补充：上面两种方式的组合：将共享数据封装在另外一个对象中，每个线程对共享数据的操作方法也分配到
     * 那个对象身上去完成，对象作为这个外部类中的成员变量或方法中的局部变量，每个线程的 Runnable 对象
     * 作为外部类中的成员内部类或局部内部类。
     * 总之，要同步互斥的几段代码最好是分别放在几个独立的方法中，这些方法再放在同一个类中，这样比较容
     * 易实现它们之间的同步互斥和通信。
     */
}
