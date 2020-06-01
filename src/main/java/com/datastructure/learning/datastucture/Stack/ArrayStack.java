package com.datastructure.learning.datastucture.Stack;

import com.datastructure.learning.datastucture.Array.Array;

/**
 * 栈的基本实现-数组实现栈的基本功能
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    //定义数组属性
    Array<E> array;

    //用户在最初就知道创建的数组最多可以承载多少元素，那么就应该传递一个容量参数
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    //不知道数组长度，在最大的时候能够承载多少元素，就不用传递这个参数
    public  ArrayStack(){
        array = new Array<>();
    }

    /**
     * 查看栈一共有多少元素
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 查看栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 获取栈存储容量
     * 特有的方法
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入栈
     * @param e
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public E pop(){
        //移出数组最后一个元素
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuffer res=new StringBuffer();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
