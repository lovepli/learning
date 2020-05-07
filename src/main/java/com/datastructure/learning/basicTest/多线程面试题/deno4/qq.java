package com.datastructure.learning.basicTest.多线程面试题.deno4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 11、同一个类中的 2 个方法都加了同步锁，多个线程能同时访问同一个类中的这两个方法吗？
 *  分析;这个问题需要考虑到 Lock 与 synchronized关键字 两种实现锁的不同情形。因为这种情况下使用 Lock 和 synchronized关键字
 * 会有截然不同的结果。 Lock 可以让等待锁的线程响应中断， Lock 获取锁，之后需要释放锁。
 *
 * 如下代码，多个线程不可访问同一个类中的 2 个加了 Lock 锁的方法。而 synchronized关键字 却行，使用 synchronized关键字 时，当我们访问同一个类对象的时候，是同一把锁，所以可以访问
 * 该对象的其他 synchronized关键字 方法。
 */
public class qq {

    private int count = 0;
    private Lock lock = new ReentrantLock();//设置 lock 锁

    //方法 1
    public Runnable run1 = new Runnable() {
        public void run() {
            lock.lock(); //加锁
            while (count < 100) {
                try {
                    //打印是否执行该方法
                    System.out.println(Thread.currentThread().getName() + " run1: " + count++);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
     lock.unlock();
    }};

    //方法 2
    public Runnable run2 = new Runnable() {
        public void run() {
            lock.lock();  //加锁
            while (count < 100) {
                try {
                    //打印是否执行该方法
                    System.out.println(Thread.currentThread().getName() + " run2: " + count++);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }};

        public static void main(String[] args) throws InterruptedException {
            qq t = new qq(); //创建一个对象
            new Thread(t.run1).start();//获取该对象的方法 1

            new Thread(t.run2).start();//获取该对象的方法 2
        }
    }


