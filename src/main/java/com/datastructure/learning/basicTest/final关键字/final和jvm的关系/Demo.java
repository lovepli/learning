package com.datastructure.learning.basicTest.final关键字.final和jvm的关系;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Demo {

    /**
     * 与前面介绍的锁和 volatile 相比较，对 final 域的读和写更像是普通的变量访问。对于 final 域，编译器和处理器要遵守两个重排序规则：
     *
     * 在构造函数内对一个 final 域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
     * 初次读一个包含 final 域的对象的引用，与随后初次读这个 final 域，这两个操作之间不能重排序。
     */
}
