package com.datastructure.learning.basicTest.设计模式.单例模式;

/**
 * @author: lipan
 * @date: 2020/6/4
 * @description: 静态内部类实现单例模式
 */
public class Singleton3 {

    private Singleton3(){}

    private static class SingletonHolder{
        public static final Singleton3 instance=new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.instance;
    }
}
