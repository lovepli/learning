package com.datastructure.learning.basicTest.设计模式.单例模式;

/**
 * @author: lipan
 * @date: 2020-01-15
 * @description: 懒汉模式（线程不安全）01
 */
public class SingletonDemo_01 {
    private static SingletonDemo_01 instance;
    private SingletonDemo_01(){

    }
    public static SingletonDemo_01 getInstance(){
        if(instance==null){
            instance=new SingletonDemo_01();
        }
        return instance;
    }
}

/**
 * 如上，通过提供一个静态的对象instance，利用private权限的构造方法和getInstance()方法来给予访问者一个单例。
 *
 * 缺点是，没有考虑到线程安全，可能存在多个访问者同时访问，并同时构造了多个对象的问题。之所以叫做懒汉模式，主要是因为此种方法可以非常明显的lazy loading。
 *
 * 针对懒汉模式线程不安全的问题，我们自然想到了，在getInstance()方法前加锁，于是就有了第二种实现
 */