package com.datastructure.learning.basicTest.多线程基础机制.多线程共享数据;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description: 1. 多个线程行为一致共同操作一个数据
 * 如果每个线程执行的代码相同，可以使用同一个 Runnable 对象，这个 Runnable 对象中有那个共享数据，例如，
 * 买票系统就可以这么做
 */

/**
 *共享数据类
 **/
class ShareData {

    private int num = 10;

    //同步方法
    public synchronized void inc() {
        num++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 *多线程类
 **/
public class RunnableCusToIncTest implements Runnable {

    //共享数据类
    private ShareData shareData;

    public RunnableCusToIncTest(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }

    /**
     *测试方法
     **/
    public static void main(String[] args) {
       ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            new Thread(new RunnableCusToIncTest(shareData), "Thread " + i).start();
        }
    }
}


