package com.datastructure.learning.basicTest.基础知识.Java代码块执行顺序;


import lombok.extern.slf4j.Slf4j;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:
 */
@Slf4j
public class B extends A {

    private static C c1 = new C("B静态成员");

    {
        log.info("B代码块");
    }

    private C c = new C("B成员");

    static {
        log.info( "B静态代码块2");
    }

    static {
        log.info("B静态代码块");
    }

    public B() {
        log.info("B构造方法");

    }

}