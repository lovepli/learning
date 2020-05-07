package com.datastructure.learning.basicTest.多线程并发库.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:  固定大小连接池
 * 从上面的运行来看，我们 Thread 类都是在线程池中运行的，线程池在执行 execute 方法来执行 Thread 类
 * 中的 run 方法。不管 execute 执行几次，线程池始终都会使用 2 个线程来处理。不会再去创建出其他线程来处理
 * run 方法执行。这就是固定大小线程池。
 */
public class Test1 {

    public static void main(String[] args) {
//创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
//创建实现了 Runnable 接口对象， Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
//将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
//关闭线程池
        pool.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。 ");
    }
}
