package com.datastructure.learning.basicTest.final关键字.最佳实践;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class ThreadLocalExample2 implements Runnable{


    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
   // private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
   //等价于 使用匿名内部类
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample2 obj = new ThreadLocalExample2();
        for(int i=0 ; i<3; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

}
