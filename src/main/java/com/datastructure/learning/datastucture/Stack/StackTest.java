package com.datastructure.learning.datastucture.Stack;

import java.util.Random;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 比较数组栈和链表栈的执行效率时间 结果 时间差不多
 */
public class StackTest {

    /**
     * 测试数组栈ArrayStack的出入栈操作
     */
    private static void arrayStackTest() {
        ArrayStack<Integer> stack=new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            //入栈
            stack.push(i);
            System.out.println(stack);
        }
        //出栈
        stack.pop();
        System.out.println(stack);
    }

    /**
     * 测试链表栈LinkedListStack的出入栈操作
     */
    private static void linkedListStackTest() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    /**
     * 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime=System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime=System.nanoTime();
        return (endTime - startTime) / 1000000000.0; //纳秒转为秒
    }

    public static void main(String[] args) {

        //arrayStackTest();

        //linkedListStackTest();

        int opCount=100000;

        //数组栈
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("arrayStack,time:"+time1+"s");  //arrayStack,time:0.021867985s

        //链表栈
        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);  //linkedListStack,time:0.021630682s
        System.out.println("linkedListStack,time:"+time2+"s");

        //其实这个时间比较复杂，因为LinkedListStack中包含更多的new操作

    }
}
