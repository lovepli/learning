package com.datastructure.learning.basicTest.设计模式.单例模式;

/**
 * @author: lipan
 * @date: 2020-01-15
 * @description: 线程安全的懒汉模式（线程安全） 02
 */
public class SingletonDemo_02 {
    private static SingletonDemo_02 instance;
    private SingletonDemo_02(){

    }
    public static synchronized SingletonDemo_02 getInstance(){
        if(instance==null){
            instance=new SingletonDemo_02();
        }
        return instance;
    }
}

/**
 * 然而并发其实是一种特殊情况，大多时候这个锁占用的额外资源都浪费了，这种打补丁方式写出来的结构效率很低。
 */