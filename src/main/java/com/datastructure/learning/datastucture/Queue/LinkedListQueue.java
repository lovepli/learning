package com.datastructure.learning.datastucture.Queue;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description:  在连标头节点head处出队 在链表尾节点tail处入队
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next; //public

        public Node(E e, Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){ //用户只传递了一个元素
            this(e,null);
        }

        public Node(){
            this(null,null);//用户什么都不传递
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;  //首节点，尾节点
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * 入队操作：尾节点添加元素  理解这里的写法
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {//说明head ==tial == NULL 此时并不是空的size == 0？？此时size 应该等于1？说明链表只有一个空元素
            tail = new Node(e);
            head = tail;
        }else{  //否则tail.next ==null;
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++ ;
    }

    /**
     * 出队操作：头节点移除元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {  //size ==0 表示为空
            throw new IllegalArgumentException("Cannot dequeue from an empty Queue.");
        }
        Node retNode = head; //将头节点赋值给返回的元素，或者说将返回的节点指向头节点
        head = head.next; //设置新的头节点，或者说是将头节点指向他的下一个节点
        retNode.next = null; //将返回的节点的指向置为空，便于垃圾回收（理解这三句话的意思）
        if (head == null) {  //也表示空？ head ==null 不表示为空？？？？ 此时size 不等于0吗？  //解释：链表中NULL也代表一个元素，它是一个对象，所以也存在一个size位置
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public  E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur =head;
        while (cur != null) {
            res.append(cur + "->");
            cur=cur.next;
        }
        res.append("NULL tial");
        return res.toString();
    }
}
