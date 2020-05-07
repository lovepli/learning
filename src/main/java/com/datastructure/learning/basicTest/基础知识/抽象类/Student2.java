package com.datastructure.learning.basicTest.基础知识.抽象类;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:
 */
//抽象类
abstract class  Person2 {

    //抽象方法 子类必须继承，否则报错
    public abstract void fun2();

    //非抽象方法
    public void fun1(){
        System.out.println("抽象父类的非抽象特有方法 -- 子类不能继承");
    }

    //构造方法
    public Person2(){
        System.out.println("抽象父类的构造方法");
    }

}

public class Student2 extends Person2 {

    public Student2(){
        System.out.println("子类的构造方法");
    }

    private void f(){
        System.out.println("这是子类的特有的方法");
    }

    @Override
    public void fun2() {
        System.out.println("这是子类继承的方法");
    }


    public static void main(String[] args) {
        Person2 p2 = new Student2();
        p2.fun1();

        Student2 stu=new Student2();
        stu.fun2();

    }
}
