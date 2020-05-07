package com.datastructure.learning.basicTest.多线程并发库.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description: 单任务连接池
 *
 * 运行结果看出，单任务线程池在执行 execute 方法来执行 Thread 类中的 run 方法。不管 execute 执行几次，线程池
 * 始终都会使用单个线程来处理。
 *
 *
 */
public class Test2 {

    public static void main(String[] args) {
//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
        ExecutorService pool = Executors.newSingleThreadExecutor();
//创建实现了 Runnable 接口对象， Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread2();
        Thread t2 = new MyThread2();
        Thread t3 = new MyThread2();
        Thread t4 = new MyThread2();
        Thread t5 = new MyThread2();
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

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。 ");
    }
}
