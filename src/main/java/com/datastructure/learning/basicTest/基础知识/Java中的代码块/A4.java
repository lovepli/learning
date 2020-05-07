package com.datastructure.learning.basicTest.基础知识.Java中的代码块;

/**
 * @author: lipan
 * @date: 2020-04-07
 * @description:  多态面试题
 */
public class A4 {

    public A4() {
        System.out.print("A gouzhao");
    }

    private static A4 a = new A4();

    static {
        System.out.print("static");
    }

    {
        System.out.print("A4");
    }
}

class B4 extends A4 {
    public B4() {
        System.out.print("4");
    }

    public static void main(String[] args) {
        System.out.println("0000");
        B4 b = new B4();
    }
    //A4A gouzhaostatic0000
    //A4A gouzhao4

    //解释： 静态变量， 静态代码块先于 System.out.println(“0000”)执行， 静态的东西只执行一
    //次， 相当于全局变量。
}

