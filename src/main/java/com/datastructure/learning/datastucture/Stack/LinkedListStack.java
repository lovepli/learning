package com.datastructure.learning.datastucture.Stack;

import com.datastructure.learning.datastucture.LinkedList.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description:v 链表栈
 */
public class LinkedListStack<E> implements Stack<E> {

    //引入链表
    private LinkedList<E> list;

    //构造函数 在创建一个stack的时候，实际上是在内存中创建了一个链表作为存储空间来存储元素
    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public  boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈 在链表头部添加新的节点
     * @param e
     */
    @Override
    public void push(E e) {
       list.addFirst(e);
    }

    /**
     * 出栈 链表的第一个节点元素
     * @return
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }
    
    /**
     * 查看栈顶元素 对应链表中的第一个节点元素
     * @return
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
