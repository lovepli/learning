package com.datastructure.learning.basicTest.设计模式.单例模式;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 *  单利模式
 *
 *  饿汉
 */
public class Singleton1 {

    private Singleton1(){}  //私有的无参构造函数

    private static Singleton1 s = new Singleton1();

    public static Singleton1 getInstance() { //共有的静态方法
        return s;
    }



}
