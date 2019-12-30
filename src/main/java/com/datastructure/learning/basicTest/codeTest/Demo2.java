package com.datastructure.learning.basicTest.codeTest;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: Java 基础知识疑难点/易错点
 * https://github.com/Snailclimb/JavaGuide
 *
 */
public class Demo2 {


    /**
     *整型包装类值的比较
     *所有整型包装类对象值的比较必须使用equals方法
     */
    public static void f1(){
        Integer x = 3;
        Integer y = 3;
        System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
    }

    public static void main(String[] args) {

    }
}
