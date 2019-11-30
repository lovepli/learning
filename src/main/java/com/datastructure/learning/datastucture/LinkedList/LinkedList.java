package com.datastructure.learning.datastucture.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-26
 * @description:  链表添加虚拟头节点dummyhead 取代head
 *链表不能直接通过index查找find()到某个节点，必须先找到前一个节点，然后通过前一个节点来获取到目标节点元素
 */
public class LinkedList<E> {
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


    private Node dummyHead;  //私有的 链表头 不能从外部进行改变，访问权限设置
    private int size;   //下一个待添加的元素

    public LinkedList(){
        dummyHead = new Node(null,null);  //虚拟头节点
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
     *
     * 在链表的index(0-based)位置添加新的元素e
     * 此方法在链表中不是一个常用的操作，练习用
     */
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
            Node prev=dummyHead;  //前一个
            for (int i = 0; i < index; i++){  //找到你要遍历的元素的前一个节点 理解index  而不是index-1 !!!
                prev=prev.next;
            }
            prev.next = new Node(e, prev.next);
            size ++;  //元素数量加一
    }

    /**
     * 在链表头添加新的元素e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    //在链表的末尾添加新的元素 直接在size的位置添加元素
    public void addLast(E e) {
        add(size,e);
    }

    /**
     *
     * 获得链表的index(0-based)位置的元素e
     * 此方法在链表中不是一个常用的操作，练习用
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
            Node cur=dummyHead.next; //当前
            for (int i = 0; i < index; i++) {
                cur =cur.next;
            }
            return cur.e;
    }

    /**
     * 获得链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素  注意这里size-1
     */
    public E getLast() {
        return get(size-1);
    }

    /**
     * 修改index位置的元素
     */
    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Illegal index");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur =cur.next;  //指向位置改变了
        }
        cur.e=e;
    }

    /**
     * 查找元素中是否有元素e
     */
    public  boolean contains(E e) {
        Node cur =dummyHead.next;
        while (cur != null) {    //TODO 注意这里的写法！！
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 在链表中删除index位置的元素
     */
    public  E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Illegal index");
        }

        Node prev =dummyHead;
        for (int i = 0; i < index; i++) {
            prev =prev.next;
        }
        Node retNode =prev.next;
        prev.next=retNode.next;
        retNode.next=null;  //垃圾回收
        return retNode.e;
    }

    /**
     * 删除链表中的第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表中的最后一个元素
     *
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     */
    public void removeElement(E e) {
        Node prev =dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode =prev.next;
            prev.next = delNode.next;
            delNode.next =null;
        }
    }


    /**
     * 遍历链表
     */

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

           Node cur =dummyHead.next;
           while (cur != null) {
            res.append(cur + "->");
            cur =cur.next;
        }

        //while也可以用for循环
//        for(Node cur =dummyHead.next; cur != null; cur =cur.next){
//            res.append(cur + "->");
//            res.append("NULL");
//        }
        res.append("NULL");
        return res.toString();
    }

    /**
     * 分析时间复杂度 增删改查的时间复杂度都是O(n)
     */


}

