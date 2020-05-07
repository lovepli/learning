package com.datastructure.learning.basicTest.设计模式.适配器模式.接口的适配器模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:  继承 Source 类(非抽象类)，实现 Targetable 接口
 */
public class Adapter extends Source  {

    @Override
    public void method1() {
        System.out.println("this is the Source method!");
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}