package com.datastructure.learning.basicTest.设计模式.适配器模式.类的适配器模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:  继承 Source 类(非抽象类)，实现 Targetable 接口
 */
public class Adapter extends Source implements Targetable {


    //只需要实现一个接口吗？？ 为什么可以实现一个，也可以都实现呢？
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    public void test(){
        System.out.println("Adapter 自己的方法");
    }

}