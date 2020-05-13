package com.datastructure.learning.basicTest.动态代理;

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

    /**
     * 二、动态代理
     * 代理模式为其它对象提供一种代理以控制对这个对象的访问。在某些情况下，一个客户不想或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
     *
     * 动态代理是指客户通过代理类来调用其它对象的方法，主要使用了Java反射机制来实现动态代理。使用Java的反射机制创建动态代理对象，让代理对象在调用目标方法之前和之后分别做一些事情，然后动态代理对象决定是否调用以及何时来调用被代理对象的方法。
     *
     * Java动态代理类位于java.lang.reflect包下，一般主要涉及到以下两个类。
     *
     * （1）InvocationHandler：该接口中仅定义了一个方法 public object invoke(Object proxy,Method method, Object[] args)，其中第一个参数proxy是代理类的实例，method是被代理的方法，即需要执行的方法，args为该方法的参数数组。这个抽象方法在代理类中动态实现。
     *
     * （2）Proxy：该类即为动态代理类。
     *
     * 动态代理的步骤
     *
     * （1）创建一个实现接口InvocationHandler的类，它必须实现invoke方法；
     *
     * （2）创建被代理的接口以及实现类；
     *
     * （3）通过Proxy的静态方法
     *
     * newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h) 创建一个代理；
     *
     * （4）通过代理调用方法。
     */
}
