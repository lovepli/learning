package com.datastructure.learning.basicTest.多线程基础机制.互斥同步;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  要求： 子线程运行执行 10 次后，主线程再运行 5 次。这样交替执行三遍
 */
class Bussiness {

    private boolean subFlag = true;

    //同步方法
    public synchronized void mainMethod() {
        while (subFlag) {
            try {
                wait();  //为true 的时候当前main线程释放锁资源，进入锁池 ，子线程获得了锁资源，程序不再继续执行下面的程序了，子线程开始执行他的操作了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " : main thread running loop count -- " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = true;
        notify();
    }

    //同步方法
    public synchronized void subMethod() {
        while (!subFlag) {
            try {
                wait();  //为true 的时候当前子线程释放锁资源，进入锁池 ，主线程获得了锁资源，程序不再继续执行下面的程序了，主线程开始执行他的操作了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //子线程执行操作
        for (int i = 0; i < 10; i++) {
            System.err.println(Thread.currentThread().getName()
                    + " : sub thread running loop count -- " + i);
            try {
                Thread.sleep(1000);  //线程休眠1秒，但是不释放锁资源
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = false;
        notify();  //唤醒等待的线程main主线程
    }
}

public class Tdemo {

    public static void main(String[] args) {

        final Bussiness bussiness = new Bussiness();

        //创建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    bussiness.subMethod();
                }
            }
        }).start();

        //主线程
        for (int i = 0; i < 3; i++) {
            bussiness.mainMethod();
        }
    }
}

