package com.datastructure.learning.basicTest.设计模式.装饰模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:  装饰者
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }


}
