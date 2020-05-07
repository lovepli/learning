package com.datastructure.learning.basicTest.多线程并发库.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description: 可变连接池
 * 运行结果看出， 可变任务线程池在执行 execute 方法来执行 Thread 类中的 run 方法。这里 execute 执行多次，
 * 线程池就会创建出多个线程来处理 Thread 类中 run 方法。所有我们看到连接池会根据执行的情况，在程序运行时创
 * 建多个线程来处理，这里就是可变连接池的特点。
 */
public class Test3 {
    public static void main(String[] args) {
//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
        ExecutorService pool = Executors.newCachedThreadPool();
//创建实现了 Runnable 接口对象， Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread3();
        Thread t2 = new MyThread3();
        Thread t3 = new MyThread3();
        Thread t4 = new MyThread3();
        Thread t5 = new MyThread3();
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

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。 ");
    }
}

