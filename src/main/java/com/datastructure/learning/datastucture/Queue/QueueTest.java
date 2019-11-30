package com.datastructure.learning.datastucture.Queue;

import java.util.Random;

/**
 * @author: lipan
 * @date: 2019-05-23
 * @description: 测试数组队列与循环队列以及链表队列的性能比较
 */
public class QueueTest {

    /**
     * 测试数组队列ArrayQueue的出入队操作
     */
    private static void arrayQueueTest() {
        ArrayQueue<Integer> queue=new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            //入队
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {  //每插入是三个元素，移除一个元素 i=2，5，8，   TODO i%3==2 2代表余数为2？  %取余数   /取整数
                //出队
                queue.dequeue();
                System.out.println("出队后的队列："+queue);
            }
        }
    }

    /**
     * 测试链表队列LinkedListQueue的出入队操作
     */
    private static void linkedListQueueTest() {
        LinkedListQueue<Integer> queue=new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            //入队
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {  //每插入是三个元素，移除一个元素 i=2，5，8，   TODO i%3==2 2代表余数为2？  %取余数   /取整数
                //出队
                queue.dequeue();
                System.out.println("出队后的队列："+queue);
            }
        }
    }

    /**
     * 测试循环队列LoopQueue的出入队操作
     */
    private static void loopQueueTest() {
        LoopQueue<Integer> queue=new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            //入队
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {  //每插入是三个元素，移除一个元素 i=2，5，8，   TODO i%3==2 2代表余数为2？  %取余数   /取整数
                //出队
                queue.dequeue();
                System.out.println("出队后的队列："+queue);
            }
        }
    }

    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime=System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
           q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime=System.nanoTime();
        return (endTime - startTime) / 1000000000.0; //纳秒转为秒


    }

    public static void main(String[] args) {

        int opCount=100000;

        //数组队列
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time:"+time1+"s");  //O(n的平方)

        //循环队列
        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);  //O(n)
        System.out.println("LoopQueue,time:"+time2+"s");

        //链表队列
        LinkedListQueue<Integer> linkedListQueue=new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);  //O(n)
        System.out.println("linkedListQueue,time:"+time3+"s");


    }
}
