package com.datastructure.learning.basicTest.多线程面试题.demo3;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 三个线程 a、 b、 c 并发运行， b,c 需要 a 线程的数据怎么实现（上海 3 期学员提供）
 */
public class ThreadCommunication {
    private static int num;//定义一个变量作为数据

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //模拟耗时操作之后初始化变量 num
                    Thread.sleep(1000);
                    num = 1;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num);
            }
        });
        Thread threadC = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获取到 num 的值为： " + num);
            }
        });
//同时开启 3 个线程
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
