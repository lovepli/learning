package com.datastructure.learning.basicTest.多线程面试题;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:
 */
public class demo {

    /**
     * 1、多线程多创建方式(3种方式)
     */

    /**
     * 2、在 java 中 wait 和 sleep 方法的不同？
     * 最大的不同是在等待时 wait 会释放锁，而 sleep 一直持有锁。 wait 通常被用于线程间交互， sleep 通常被用于暂
     * 停执行。
     */

    /**
     *
     * 3、synchronized 和 volatile 关键字的作用
     * 一旦一个共享变量（类的成员变量、类的静态成员变量）被 volatile 修饰之后，那么就具备了两层语义：
     * 1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是
     * 立即可见的。
     * 2）禁止进行指令重排序。
     * volatile 本质是在告诉 jvm 当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取；
     * synchronized 则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
     * 1.volatile 仅能使用在变量级别；
     * synchronized 则可以使用在变量、方法、和类级别的
     * 2.volatile 仅能实现变量的修改可见性，并不能保证原子性；
     * synchronized 则可以保证变量的修改可见性和原子性
     * 3.volatile 不会造成线程的阻塞；
     * synchronized 可能会造成线程的阻塞。
     * 4.volatile 标记的变量不会被编译器优化；
     * synchronized 标记的变量可以被编译器优化
     */

    /**
     * 5、什么是线程池，如何使用
     * 线程池就是事先将多个线程对象放到一个容器中，当使用的时候就不用 new 线程而是直接去池中拿线程即可，节
     * 省了开辟子线程的时间，提高的代码执行效率。
     * 在 JDK 的 java.util.concurrent.Executors 中提供了生成多种线程池的静态方法。
     *
     * 1. ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
     * 2. ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
     * 3. ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4);
     * 4. ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
     * 然后调用他们的 execute 方法即可。
     */

    /**
     * 6、常用的线程池有哪些？
     */

    /**
     * 7、请叙述一下您对线程池的理解？
     * 如果问到了这样的问题，可以展开的说一下线程池如何用、线程池的好处、线程池的启动策略）
     */

    /**
     * 8、线程池的启动策略？
     */
}
