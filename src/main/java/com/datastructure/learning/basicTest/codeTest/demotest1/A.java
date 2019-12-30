package com.datastructure.learning.basicTest.codeTest.demotest1;

import java.util.ArrayList;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: 局部代码块的使用
 */
public class A {

    public static void main(String[] args) {
        B b = new B();
        b.go();
    }
}

class B {
    B(){}
    public void go() {
        //方法中的局部代码块，一般进行一次性地调用，调用完立刻释放空间，避免在接下来的调用过程中占用栈空间
        //因为栈空间内存是有限的，方法调用可能会会生成很多局部变量导致栈内存不足。
        //使用局部代码块可以避免这样的情况发生。
        {
            int i = 1;
            ArrayList<Integer> list = new ArrayList<>();
            while (i < 10) {
                list.add(i ++);
            }
            for (Integer j : list) {
                System.out.println(j);
            }
            System.out.println("gogogo");
        }
        System.out.println("hello");
    }
}
