package com.datastructure.learning.basicTest.多态.demotest5;

/**
 * @author: lipan
 * @date: 2020-04-09
 * @description:  多态题目
 * java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。
 * instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 */
public class instanceoftest {

    public static void main(String[] args) {

        A a = null;
        B b = null;
        boolean res;

        System.out.println("instanceoftest test case 1: ------------------");
        res = a instanceof A;
        System.out.println("a instanceof A: " + res);  //false

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);  //false

        System.out.println("/ninstanceoftest test case 2: ------------------");
        a = new B();  //多态
        b = new B();

        res = a instanceof A;
        System.out.println("a instanceof A: " + res);  //true

        res = a instanceof B;
        System.out.println("a instanceof B: " + res);  //true

        res = b instanceof A;
        System.out.println("b instanceof A: " + res);  //true

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);  //true

        System.out.println("/ninstanceoftest test case 3: ------------------");
        B b2 = new C();  //多态

        res = b2 instanceof A;
        System.out.println("b2 instanceof A: " + res);  //true

        res = b2 instanceof B;   //b2 是 B类 的子类C的实例
        System.out.println("b2 instanceof B: " + res);  //true

        res = b2 instanceof C;   //b2 是 类C
        System.out.println("b2 instanceof C: " + res);  //true
    }

}

