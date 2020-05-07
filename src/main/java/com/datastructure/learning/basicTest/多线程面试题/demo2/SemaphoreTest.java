package com.datastructure.learning.basicTest.多线程面试题.demo2;

import java.util.concurrent.Semaphore;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:  9、如何控制某个方法允许并发访问线程的个数？
 */
public class SemaphoreTest {
    /*
    * permits the initial number of permits available. This value may be negative,
    in which case releases must occur before any acquires will be granted.
    fair true if this semaphore will guarantee first-in first-out granting of
    permits under contention, else false
    */
    static Semaphore semaphore = new Semaphore(5,true);
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {

                @Override
                public void run() {
                    test();
                }
            }).start();
        }

    }

    public static void test(){
        try {
            //申请一个请求
            semaphore.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"进来了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"走了");
        //释放一个请求
        semaphore.release();
    }
}

