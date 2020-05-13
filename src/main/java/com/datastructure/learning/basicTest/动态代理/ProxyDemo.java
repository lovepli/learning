package com.datastructure.learning.basicTest.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-04-15
 * @description:  java中的动态代理
 *
 * 写一个 ArrayList 的动态代理类（笔试题）
 *
 * 参考：https://blog.csdn.net/wangpf2011/article/details/84679377
 * 动态代理主要使用了Java反射机制来实现，而拦截器Interceptor又是通过动态代理实现的
 */
public class ProxyDemo {

    public static void proxTest(){

        // 被代理对象，其中List为接口，ArrayList为接口实现类
        final List<String> list = new ArrayList<>();

        //匿名内部类
        // 动态生成的代理对象
        // list.getClass().getInterfaces()和Java的反射机制有关，它能够获得这个对象所实现的接口
        List<String> listProxy=(List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法调用前~~");
                Object temp = method.invoke(list, args);
                System.out.println("方法调用后~~");
                return temp;
            }
        });
        // 通过代理对象执行方法add
        listProxy.add("你好") ;
        System.out.println(list);
    }

    /**
     *
    public static void proxyTest(){
        // 被代理对象，其中Subject为接口，SubjectImpl为接口实现类
        Subject target = new SubjectImpl();
        // 动态生成的代理对象
        // target.getClass().getInterfaces()和Java的反射机制有关，它能够获得这个对象所实现的接口
        Subject porxy = (Subject)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法调用前~~");
                Object temp = method.invoke(target, args);
                System.out.println("方法调用后~~");
                return temp;
            }
        });
        // 通过代理对象执行方法say
        porxy.say("wangpf", 20);
    }
     */



    public static void main(String[] args) {
        // 因为改动态代理方法使用的是匿名内部类实现的,所以上面的list对象使用final修饰(被final修饰其地址值不变,才可以在匿名内部类中被使用)
        proxTest();
    }




}
