package com.datastructure.learning.basicTest.多态.demotest3;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:
 *解析：
 * java中变量不能重写，可以按如下口诀记忆
 * 变量多态看左边，
 * 方法多态看右边，
 * 静态多态看左边。
 */
public class A {

    public static String s="hello";
    public int i = 0;
    public void fun(){
        System.out.println("-----A-----");
    }

    public static void f(){
        System.out.println("A--hello");
    }
}

class B extends A{
    public static String s="world";
    public int i = 1;
    public void fun(){
        System.out.println("-----B-----");
    }

    public static void f(){
        System.out.println("B--hello");
    }

    public static void main(String[] args){
        A a = new B();
        System.out.println(a.i);
        a.fun();
        System.out.println(a.s);
        a.f();

//        0
//        -----B-----
//        hello
//        A--hello

//        B b= (B) new A();
//        System.out.println(b.i);
//        b.fun();



    }
}
