package com.datastructure.learning.basicTest.设计模式.适配器模式.类的适配器模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public interface Targetable {

    /* 与原类中的方法相同 */
    public void method1();
    /* 新类的方法 */
    public void method2();
}