package com.datastructure.learning.basicTest.多线程基础机制.多线程共享数据.demo2;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 *
 * 2) 将这些 Runnable 对象作为某一个类中的内部类，共享数据作为这个外部类中的成员变量，每个线程对
 * 共享数据的操作方法也分配给外部类，以便实现对共享数据进行的各个操作的互斥和通信，作为内部类的各个
 * Runnable 对象调用外部类的这些方法
 */
public class Demo3 {

    public static void main(String[] args) {
         //公共数据
        final ShareData3 shareData = new ShareData3();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.inc();
                        }
                    }
                }, "Thread " + i).start();
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            shareData.dec();
                        }
                    }
                }, "Thread " + i).start();
            }
        }
    }
}

class ShareData3{

    private int num = 10;

    public synchronized void inc() {
        num++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dec() {
        num--;
        System.err.println(Thread.currentThread().getName() + ": invoke dec method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

