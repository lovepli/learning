package com.datastructure.learning.datastucture.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-23
 * @description: 链表 链表是一种数据结构，和数组同级。 比如，Java中我们使用的ArrayList，其实现原理是数组。
 *     而LinkedList的实现原理就是链表了。链表在进行循环遍历时效率不高，但是插入和删除时优势明显。
 *
 *     单向链表是一种线性表，实际上是由节点（Node）组成的，一个链表拥有不定数量的节点。其数据在内存中存储是不连续的，
 *     它存储的数据分散在内存中，每个结点只能也只有它能知道下一个结点的存储位置。由N各节点（Node）组成单向链表，
 *     每一个Node记录本Node的数据及下一个Node。向外暴露的只有一个头节点（Head），我们对链表的所有操作，
 *     都是直接或者间接地通过其头节点来进行的。
 *
 *     单链表最左边的节点即为头结点（Head），但是添加节点的顺序是从右向左的，添加的节点会被作为新节点。最先添加的节点对下一节点的引用可以为空。
 *     引用是引用下一个节点(在内存中的存储地址)而非下一个节点的对象。因为有着不断的引用，所以头节点就可以操作所有节点了。
 *
 *     下图描述了单向链表存储情况。存储是分散的，每一个节点只要记录下一节点(在内存中的存储地址)，就把所有数据串了起来，形成了一个单向链表。
 *     参考：https://blog.csdn.net/jianyuerensheng/article/details/51200274
 */
public class LinkedList1<E> {
     /** 私有内部类*/
     private class Node{//节点
         public E e;  //元素,即节点存储的值
         public Node next; //节点的引用，指向下一个节点 public

         public Node(E e,Node next){
             this.e=e;
             this.next=next;
         }

         /**
          * 传入元素e，没有节点的引用
          * @param e
          */
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


    private Node head;  //链表头节点 私有的 不能从外部进行改变，访问权限设置
    private int size;   //记录链表中有多少元素

    //无参构造器  为什么没有有参构造函数？ 链表不是一个初始化固定容量的容器，他是一个依次加一容量动态增加的对象，所以没有初始容量capacity这个值
    //初始链表长度为0
    public LinkedList1(){
        head = null;  //初始化的时候是空的，没有节点
        size = 0;
    }

    //可以根据需要写一个传入 数组作为参数，返回链表的有参构造函数

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
   * 添加节点的顺序是从右向左的，添加的节点会被作为新节点
   * @param e
   */
  public void addFirst(E e) {
      //1、创建新的节点node 里面传入的元素e
    //        Node node = new Node(e);
      //2、node节点的引用指向头节点head
    //        node.next=head;
      //3、head更新一下，他等于新的node节点
    //        head = node;

    // 一句话总结三句话
    head = new Node(e, head);
    size++;
}

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 索引index在链表中不是一个常用的操作，练习用 对于链表来说是没有索引这个概念的，这里只是借用这个来理解链表
     * 在链表中间添加元素的关键：找到要添加的节点的前一个节点，index位置将链表分割成两部分了
     * @param index
     * @param e
     */
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        }else {
            //设置一个Node 叫做prev 他从head开始
            Node prev=head;    //TODO 注意理解 prev和prev.next的区别，prev是当前节点的内存地址，prev.next的值记录的是下一个节点在内存中的地址
            for (int i = 0; i < index - 1; i++){  //从链表头一直往下一个，找到待插入的index位置的前一个位置 index-1的位置
                //把当前prev存的这个节点的下一个节点放进prev这个变量中，我们的prev这个变量就会在我们的链表中一直向前移动，直到移动到index-1这个位置
                prev=prev.next;  //prev这个指针一直在向前推进
            }
//                Node node = new Node(e);  //新new一个Node 他传入的元素为e  此时这个新的节点他的next是为null的
//                node.next=prev.next;  //新new出来的节点他的next指向prev的next    即index位置的节点的内存地址赋值给node的next存储起来
//                prev.next=node;  //prev的next等于我们新建的node  prev的指针next(next的值等于下一个节点在内存中的地址)指向了node的地址(Node对象在内存中的地址)
                                   //node的内存地址赋值给node的前一个节点prev的next存储起来
            // 一句话总结三句话
                prev.next = new Node(e, prev.next);
                size ++;  //元素数量加一
        }
    }

    /**
     * 在链表的末尾添加新的元素 直接在size的位置添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 线性数据结构
     *
     * 动态数组，栈，队列的共通特性：底层依托静态数组，靠resize解决固定容量问题
     *
     * 而链表是一种真正的动态数据结构：
     * 是最简单的动态数据结构
     * 链表的更深入的理解引用(或者指针)
     * 更深入的理解递归
     *
     */

    /**
     * 链表：
     * 数据存储在"节点"(Node)中  ,可以把链表看作是火车，每一个节点就是一节车厢，在车厢中存储真正的数据，
     * 而车厢和车箱之间还要进行连接，以使得我们的数据是整合在一起的，用户可以在所有的数据上进行查询等的操作，那么数据和数据之间的连接就是由这个next来完成的
     * class Node{
     *     E e;
     *     Node next; //next引用，指向下一个节点
     * }
     * 链表的优点：真正的动态，不需要处理固定容量的问题
     * 缺点：丧失了随机访问的能力
     * （数组的每一个元素在内存的分布式连续的，所以可以通过元素的索引快速的查找到，而链表的每个节点在内存里分布都是连续的，随机分布的，所以我们必须通过引用将一个一个节点连接起来）
     */



}
