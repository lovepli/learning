package com.datastructure.learning.basicTest.多线程面试题.demo7;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class Demo {

    /**
     * Java 中多线程间的通信怎么实现?
     *
     * 线程通信的方式：
     * 1.共享变量
     * 线程间通信可以通过发送信号，发送信号的一个简单方式是在共享对象的变量里设置信号值。线程 A 在一个
     * 同步块里设置 boolean 型成员变量 hasDataToProcess 为 true，线程 B 也在同步块里读取 hasDataToProcess
     * 这个成员变量。这个简单的例子使用了一个持有信号的对象，并提供了 set 和 get 方法:
     *
     * 2.wait/notify 机制
     * 以资源为例，生产者生产一个资源，通知消费者就消费掉一个资源，生产者继续生产资源，消费者消费资源，以
     * 此循环。
     */
}
