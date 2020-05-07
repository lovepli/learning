package com.datastructure.learning.basicTest.多线程面试题.deno4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class qq2 {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    public Runnable run1 = new Runnable() {
        public void run() {
            synchronized (this) { //设置关键字 synchronized关键字，以当前类为锁
                while (count < 10) {
                    try {
                        //打印是否执行该方法
                        System.out.println(Thread.currentThread().getName() + " run1: " + count++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public Runnable run2 = new Runnable() {
        public void run() {
            synchronized (this) {
                while (count < 10) {
                    try {
                        System.out.println(Thread.currentThread().getName()
                                + " run2: " + count++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        qq2 t = new qq2(); //创建一个对象
        new Thread(t.run1).start(); //获取该对象的方法 1
        new Thread(t.run2).start(); //获取该对象的方法 2
    }
}


