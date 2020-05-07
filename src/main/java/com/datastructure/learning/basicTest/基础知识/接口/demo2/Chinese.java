package com.datastructure.learning.basicTest.基础知识.接口.demo2;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description: JavaSE 8新特性：1.接口可以定义非抽象方法  但必须使用default或者staic关键字来修饰
 */
public interface Chinese {
    //小结：2.JDK1.8规定只能在接口定义defult方法  且必须加Body实现
    default String speak() {
        return "会说普通话!";
    }
    //小结：3.接口的默认实现方法支持重载
    default String speak(String language) {
        return "会说"+language;
    }

    //小结：4.接口可以定义static方法
    static void hehe() {
        System.out.println("我不告诉你");
    }

    //抽象方法
    abstract void fun();

}
