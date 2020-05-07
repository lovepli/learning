package com.datastructure.learning.basicTest.基础知识.接口.demo2;

import java.lang.reflect.Method;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:
 */
public class InterDemo2 implements Chinese {

    //必须实现接口的抽象方法，可以不实现非抽象方法
    @Override
    public void fun() {

        System.out.println("继承接口并重写的方法");

    }

    public static void test() throws NoSuchMethodException {
        //小结：6.如果实现类没有重写接口的默认方法，则该类直接调用接口的默认实现方法
        System.out.println(new Chinese() {
            @Override
            public void fun() {

            }
        }.speak());

        System.out.println(new Chinese() {
            @Override
            public void fun() {

            }
        }.speak("粤语"));
//小结：7.接口的default方法可以被子类重写成普通方法
        System.out.println(new Chinese() {
            public String speak() {
                return "会说鸟语";
            }

            @Override
            public void fun() {

            }
        }.speak());

//小结：JDK1.8甚至允许直接调用接口的静态方法
        Chinese.hehe();

//小结：JDK1.8 可以通过反射来 判断接口的某个方法是否为default方法
        Method m = Chinese.class.getMethod("speak");
        System.out.println("It is " + m.isDefault() + " that " + m.getName() + " is default method");
    }

    public static void main(String[] args) throws NoSuchMethodException {

       // test();

        InterDemo2 t=new InterDemo2();
        t.fun();
        t.speak();  //没有输出？？
        t.speak("湖北话"); //没有输出？？

    }
}
