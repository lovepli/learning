package com.datastructure.learning.basicTest.多线程并发库.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description: 延迟连接池
 * Executors 还可以在执行某个线程时，定时操作。那么下面我们通过代码简单演示
 * 下
 */
public class Test4 {

    public static void main(String[] args) {
        //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
//创建实现了 Runnable 接口对象， Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread4();
        Thread t2 = new MyThread4();
        Thread t3 = new MyThread4();
        Thread t4 = new MyThread4();
        Thread t5 = new MyThread4();
//将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
//使用定时执行风格的方法
        pool.schedule(t4, 10, TimeUnit.MILLISECONDS); //t4 和 t5 在 10 秒后执行
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
//关闭线程池
        pool.shutdown();
    } }
class MyThread4 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。 ");
    }
    }

