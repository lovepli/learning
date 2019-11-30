package com.datastructure.learning.datastucture.Queue;

/**
 * first in first out
 * */
public interface Queue<E> {

    //入队 向队列中添加元素
    void enqueue(E e);

   //出队 从队列中移除元素
    E dequeue();

    //查看队首的元素
    E getFront();

    int getSize();

    boolean isEmpty();



}
