package com.datastructure.learning.basicTest.设计模式.适配器模式.对象的适配器模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}

