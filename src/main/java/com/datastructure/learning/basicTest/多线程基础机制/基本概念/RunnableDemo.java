package com.datastructure.learning.basicTest.多线程基础机制.基本概念;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
      while(true){
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName());
      }
    }

    public static void main(String[] args) {

        RunnableDemo myThread=new RunnableDemo();
        Thread thread=new Thread(myThread);
        thread.start();


    }
}
