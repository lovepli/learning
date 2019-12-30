package com.datastructure.learning.basicTest.codeTest.demotest3;

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
    public int i = 0;
    public void fun(){
        System.out.println("-----A-----");
    }
}

class B extends A{
    public int i = 1;
    public void fun(){
        System.out.println("-----B-----");
    }

    public static void main(String[] args){
        A a = new B();
        System.out.println(a.i);
        a.fun();
//        0
//        -----B-----

//        B b= (B) new A();
//        System.out.println(b.i);
//        b.fun();

    }
}
