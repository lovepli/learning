package com.datastructure.learning.basicTest.多线程并发库;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description: Java5之后新增加java.util.concurrent 包
 */
public class Demo {

    /**
     * 1) java.util.concurrent 包 (多线程并发库)
     *     包含核心组件：执行程序(线程池) ，并发队列，同步器，并发Condition
     * 2) java.util.concurrent.atomic 包 (多线程的原子性操作提供的工具类)
     * 3) java.util.concurrent.lock 包 (多线程的锁机制)
     *   Lock 接口,ReadWriteLock 接口,Condition 接口
     */


    /**
     * Java5 中并发库中，线程池创建线程大致可以分为下面三种：
     * //创建固定大小的线程池
     * ExecutorService fPool = Executors.newFixedThreadPool(3);
     * //创建缓存大小的线程池
     * ExecutorService cPool = Executors.newCachedThreadPool();
     * //创建单一的线程池
     * ExecutorService sPool = Executors.newSingleThreadExecutor();
     */

    /**
     * 补充：在 java 的多线程中，一但线程关闭，就会成为死线程。关闭后死线程就没有办法在启动了。再次启动就会出现
     * 异常信息： Exception in thread "main" java.lang.IllegalThreadStateException。那么如何解决这个问题呢？
     * 我们这里就可以使用 Executors.newSingleThreadExecutor()来再次启动一个线程。（面试）
     */


    /**
     *  BIO  NIO AIO的解释说明
     */

    /**
     * BIO
     *
     * 1、同步井阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进
     *
     * 行处理，如果这个连接不倣任何事情会造成不必要的线程开销，当然可以通过线程池机制改。
     *
     * 2、BIO 方式适用于连接数目比较小且固定的架构，这种方式对服务器资源翌求比较高，并发局限于应用中，JK1.4 以前的唯一选择，但程序直观简单易理解。
     */

    /**
     * NIO
     *
     * 1、同步非阻塞，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理
     *
     * 2、NIO方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，JDK1,4开始支持
     *
     */


     /**
     * Alo
     *
     * 1、异步非阻塞,服务器实现式为一个有效请求一个线程,客户端的I/O请求都是由先完成了再通知服务器应
     *
     * 用去启动线程进行处理
     *
     * 2、AIO 方式使用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用 os参与并发操作，编
     *
     * 程比较复杂，JDK7 开始支持。
     */
}
