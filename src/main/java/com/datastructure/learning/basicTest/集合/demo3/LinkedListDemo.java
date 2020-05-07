package com.datastructure.learning.basicTest.集合.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description: 请用两个队列模拟堆栈结构
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>(); //a 队列
        Queue<String> queue2=new LinkedList<String>(); //b 队列
        ArrayList<String> a=new ArrayList<String>(); //arrylist 集合是中间参数
        //往 a 队列添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        System.out.print("进栈： ");
        //a 队列依次加入 list 集合之中
        for(String q : queue){
            a.add(q);
            System.out.print(q);
        }
        //以倒序的方法取出（a 队列依次加入 list 集合）之中的值，加入 b 对列
        for(int i=a.size()-1;i>=0;i--){
            queue2.offer(a.get(i));
        }
        //打印出栈队列
        System.out.println("");
        System.out.print("出栈： ");

     for(String q : queue2){
            System.out.print(q);
        }
    }
}

/**
 * 2. 请用两个队列模拟堆栈结构
 * 两个队列模拟一个堆栈，队列是先进先出，而堆栈是先进后出。模拟如下
 * 队列 a 和 b
 * （1） 入栈： a 队列为空， b 为空。例： 则将” a,b,c,d,e” 需要入栈的元素先放 a 中， a 进栈为” a,b,c,d,e”
 * （2） 出栈： a 队列目前的元素为” a,b,c,,d,e” 。将 a 队列依次加入 Arraylist 集合 a 中。以倒序的方法，将 a 中的集
 * 合取出，放入 b 队列中，再将 b 队列出列。
 */
