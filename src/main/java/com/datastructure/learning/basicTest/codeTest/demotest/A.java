package com.datastructure.learning.basicTest.codeTest.demotest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:
 */
@Slf4j
public class A {

    static {
        log.info("A静态代码块");
    }

    private static C c = new C("A静态成员");
    private  C c1 = new C("A成员");

    {
        log.info( "A代码块");
    }

    static {
        log.info("A静态代码块2");
    }

    public A() {
        log.info( "A构造方法");
    }

}