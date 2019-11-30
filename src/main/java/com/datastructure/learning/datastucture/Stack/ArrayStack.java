package com.datastructure.learning.datastucture.Stack;

import com.datastructure.learning.datastucture.Array.Array;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    //用户在最初就知道创建的数组最多可以承载多少元素，那么就应该传递一个容量参数
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    //不知道数组长度，在最大的时候能够承载多少元素，就不用传递这个参数
    public  ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

  //特有的方法
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

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
