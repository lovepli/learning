package com.datastructure.learning.basicTest.final关键字.final和jvm的关系;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 这里假设一个线程 A 执行 writer () 方法，随后另一个线程 B 执行 reader () 方法。下面我们通过这两个线程的交互来说明这两个规则。
 */
public class FinalExample {
    int i;                              // 普通变量
   // final int j;                      //final 变量
    static FinalExample obj;


    public void FinalExample () {     // 构造函数
        i = 1;                        // 写普通域
      //  j = 2;                        // 写 final 域
    }

    public static void writer () {    // 写线程 A 执行
        obj = new FinalExample ();
    }

    public static void reader () {       // 读线程 B 执行
        FinalExample object = obj;       // 读对象引用
        int a = object.i;                // 读普通域
       // int b = object.j;                // 读 final 域
    }


}
