package com.datastructure.learning.basicTest.designPetterns.singletonPettern;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 * 单例模式：懒汉，延迟加载
 */
public class Singleton2 {

    private Singleton2() {  //私有的构造函数

    }

    private static Singleton2 s = null;

    public static Singleton2 getInstance() { //共有的静态方法
        if (s == null) {   //需要的时候再new对象
            s = new Singleton2();
            return s;
        }
        return null;
    }
}
