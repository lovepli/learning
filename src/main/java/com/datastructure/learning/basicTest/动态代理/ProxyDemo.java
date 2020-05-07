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
 */
public class ProxyDemo {

    public static void proxTest(){

        final ArrayList<String> list = new ArrayList<>();

        //匿名内部类
        List<String> listProxy=(List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list,args);
            }
        });
        listProxy.add("你好") ;
        System.out.println(list);
    }


    public static void main(String[] args) {
        // 因为改动态代理方法使用的是匿名内部类实现的,所以上面的list对象使用final修饰(被final修饰其地址值不变,才可以在匿名内部类中被使用)
        proxTest();
    }




}
