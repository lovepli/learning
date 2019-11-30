package com.datastructure.learning.datastucture.Stack;

/**
 * last in first out
 *
 * undo操作 -编辑器
 * 系统调用 -操作系统
 * 括号匹配-编译器
 *
 * */

public interface Stack<E> {

    //入栈(向栈中添加元素)的方法push
    void push(E e);


    //出栈(从栈中拿出栈顶元素)的方法pop
    E pop();

    //查看栈顶元素是谁peek
    E peek();

    //查看栈是否为空isEmpty
    boolean isEmpty();

    //产看栈的一共有多少个元素
    int getSize();



}
