package com.datastructure.learning.datastucture.Queue;

/**
 * 循环队列:理解循环队列的设计思想
 * 循环队列的复杂度均摊都为O(1)
 *
 * 循环队列还是在数组上面演进而来
 * */

public class LoopQueue<E> implements  Queue<E> {

    private E [] data;
    //队首和队尾元素的位置   队尾元素的位置代表的是数组中下一个新的元素入队的位置 即队列中最后一个元素的后一个位置
    private int front,tail;
    //实际数组元素的多少
    private int size;  //不增加size变量，实现循环队列

    public LoopQueue(int capacity){
        data= (E[]) new Object[capacity+1];  // TODO 理解视频图例 有意识的浪费了一个空间 capacity+1 不理解？？ data.length=capacity+1
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }


    //最多可以容纳多少元素
    public int getCapacity(){

        return data.length-1;  //data.length-1 表示减去一个浪费的不占元素的空间 此时data.length的实际长度又变为了capacity
    }

    /**
     *  队列为空的条件：front == tail
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    /**
     * 入队
     * 判断队列满的条件：(tail+1)%capacity ==  front
     * */
    @Override
    public void enqueue(E e) {
        //队满 扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity()*2);  //这里不是用data.length*2 因为浪费了一个空间
        }
        data[tail]=e;
        tail = (tail + 1)%data.length;  //循环
        size++;
    }

    /**
     * 动态队列
     * @param newCapacity
     * 私有方法
     */
    private void resize(int newCapacity) {
        E [] newData= (E[]) new Object[newCapacity+1];
        //TODO 遍历当前元素中所有元素的方式一：
        for (int i = 0; i < size; i++) {
            newData[i]=data[(i+front)%data.length]; //注意front偏移 newDzta[i] !=data[i]
        }
        data=newData;
        front=0;  //队首置为零
        tail=size;

    }


    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty Queue.");
        }
        E ret = data[front];
        data[front]=null;
        front =(front+1)%data.length;//循环
        size--;
        //缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {  //注意这两个条件 getCapaity()/2 !=0 即数组只有一个元素时不进行缩容 getCapacity()/4 size实际长度为容量的1/4时才缩容
            resize(getCapacity()/2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front [");
        //TODO 遍历当前元素中所有元素的方式二：纸笔写一下
        for (int i = front; i != tail; i= (i+1) % data.length) {
            res.append(data[i]);
            if ((i+1)%data.length!=tail) { //当前元素的索引不是最后一个元素
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
