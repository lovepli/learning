package com.datastructure.learning.basicTest.多线程基础机制.基本概念;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  继承Thread类
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("线程睡眠了两秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //run()方法和start()方法的不同
       // new ThreadDemo().run();
        new ThreadDemo().start();
    }

}
