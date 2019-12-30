package com.datastructure.learning.basicTest.codeTest.demotest2;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:
 */
class A {

    A() {
        System.out.println("1A类的构造方法");
    }

    {
        System.out.println("2A类的构造快");
    }

    static {
        System.out.println("3A类的静态块");
    }
}

public class B extends A {

     B() {
        System.out.println("4B类的构造方法");
    }

    {
        System.out.println("5B类的构造快");
    }

    static {
        System.out.println("6B类的静态块");
    }


    public static void main(String[] args) {
        System.out.println("7");
        new B();
        new B();
        System.out.println("8");

        //736215421548 错误！！

        //36 7 21542154 8
    }
}