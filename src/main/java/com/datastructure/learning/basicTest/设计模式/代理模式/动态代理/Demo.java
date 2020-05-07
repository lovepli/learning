package com.datastructure.learning.basicTest.设计模式.代理模式.动态代理;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class Demo {

    /**
     *    动静态代理的区别，什么场景使用？
     *
     * 1、静态代理通常只代理一个类，动态代理是代理一个接口下的多个实现类。
     *
     * 2、静态代理事先知道要代理的是什么，而动态代理不知道要代理什么东西，只有在运行时才知道
     *
     * 3、动态代理是实现 JDK 里的 InvocationHandler 接口的 invoke 方法，但注意的是代理的是接口，也就是你的
     * 业务类必须要实现接口，通过 Proxy 里的 newProxyInstance 得到代理对象。
     *
     * 4、还有一种动态代理 CGLIB，代理的是类，不需要业务类继承接口，通过派生的子类来实现代理。通过在运行
     * 时，动态修改字节码达到修改类的目的。
     *
     * 5、AOP 编程就是基于动态代理实现的，比如著名的 Spring 框架、 Hibernate 框架等等都是动态代理的使用例子。
     */
}
