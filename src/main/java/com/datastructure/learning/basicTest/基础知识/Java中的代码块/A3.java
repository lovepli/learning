package com.datastructure.learning.basicTest.基础知识.Java中的代码块;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: 静态代码块的使用
 */
public class A3 {

    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        //结果,静态代码块只会调用一次，类的所有对象共享该代码块
        //一般用于类的全局信息初始化

        //输出内容：
        //静态代码块调用
        //代码块调用
        //构造方法调用
        //代码块调用
        //构造方法调用
    }
}

class C{
    C(){
        System.out.println("构造方法调用");
    }

    {
        System.out.println("代码块调用");
    }

    static {
        System.out.println("静态代码块调用");
    }
}
