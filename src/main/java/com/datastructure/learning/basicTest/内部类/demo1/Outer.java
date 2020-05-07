package com.datastructure.learning.basicTest.内部类.demo1;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class Outer {

    //内部类
    class Inner {
    }

    public static void foo() {
      //  new Inner(); //受检查异常，idea提示出现错误
        new Outer().new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
      //  new Inner();  //受检查异常，idea提示出现错误
        new Outer().new Inner();
    }


    /**
     * 注意： Java 中非静态内部类对象的创建要依赖其外部类对象，上面的面试题中 foo 和 main 方法都是静态方
     * 法，静态方法中没有 this，也就是说没有所谓的外部类对象，因此无法创建内部类对象，如果要在静态方法中创建内
     * 部类对象，可以这样做
     * 1． new Outer().new Inner();
     */
}

