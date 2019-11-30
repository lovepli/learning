package com.datastructure.learning.datastucture.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-23
 * @description:链表
 */
public class LinkedList2<E> {
     /** 私有内部类*/
     private class Node{
         public E e;
         public Node next; //public

         public Node(E e,Node next){
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


    private Node head;  //私有的 链表头 不能从外部进行改变，访问权限设置
    private int size;   //下一个待添加的元素

    public LinkedList2(){
        head = null;
        size = 0;
    }

    /**
     *获取链表中的元素个数
     */
    public int getSize() {
        return size;
    }

    /** 返回链表是否为空*/
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next=head;
//        head = node;

        //一句话总结三句话
        head = new Node(e,head);
        size ++;
    }

    //在链表的index(0-based)位置添加新的元素e
    //索引index在链表中不是一个常用的操作，练习用
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        }else {
            Node prev=head;
            for (int i = 0; i < index - 1; i++){  //从链表头一直往下一个，找到待插入的index位置的前一个位置 index-1的位置
                prev=prev.next;
            }
//                Node node = new Node(e);
//                node.next=prev.next;
//                prev.next=node;

                prev.next = new Node(e, prev.next);
                size ++;  //元素数量加一
        }
    }

    //在链表的末尾添加新的元素 直接在size的位置添加元素
    public void addLast(E e) {
        add(size,e);
    }



}
