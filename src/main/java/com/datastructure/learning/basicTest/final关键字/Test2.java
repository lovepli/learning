package com.datastructure.learning.basicTest.final关键字;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Test2 {

    final int a = 1;

    final int[] b = {1};
    final int[] c = {1};

    final String aa = "a";

    /**
     * final修饰基本类型变量和引用
     */
    public void f() {
        //b = c;//报错
        b[0] = 1;
        //aa = "b";//报错

        final Test2 f = new Test2();
        // f = null;//报错
        //f.a = 1; //报错
    }
}

