package com.datastructure.learning.datastucture.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-26
 * @description:  链表添加虚拟头节点dummyhead 取代head
 *链表不能直接通过index查找find()到某个节点，必须先找到前一个节点，然后通过前一个节点来获取到目标节点元素
 * 注意理解什么时候是通过虚拟头节点开始，什么时候是从index为0的节点开始！！！！
 * 从虚拟头节点开始，即将虚拟头节点的位置当作index=0;
 * TODO 总结：
 * 0、虚拟头节点的作用，就是为了满足每个节点都有前一个节点而诞生的
 * 1、添加，删除的操作的时候，都是从虚拟头节点开始(因为添加和删除第一个元素，要先找到头节点)，查询，修改的时候从index为0的节点位置开始(因为查询和修改都是从链表存储元素的节点查找，即从index=0位置开始，所以不包含头节点，头节点是虚拟的，不包含元素，不是实际我们需要查找的节点)
 * 2、进行节点的增删改查的操作，遍历的时候都是先要找到待操作的节点的位置的前一个节点，然后通过前一个节点来获取目标节点(位置)进行操作
 *
 *
 */
public class LinkedList2<E> {
    /** 私有内部类*/
    private class Node{
        public E e;   //节点内的元素
        public Node next; //指向下一个节点的指针，next变量存储的是即是下一个节点在内存中的值

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

//        @Override
//        public String toString(){
//            return e.toString();
//        }


        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }


    private Node dummyHead;  //私有的 链表头 不能从外部进行改变，访问权限设置
    private int size;   //下一个待添加的元素 即链表中存储的元素的多少

    //这个链表只有无参构造器，没有有参构造器
    public LinkedList2(){
        dummyHead = new Node(null,null);  //初始化的时候通过 new Node()在内存中创建了存储空间，所以此时存在一个节点，这个节点就是那个唯一的虚拟节点
        //虚拟头节点 不存储任意的元素，next指针为null,即没有记录指向的节点的内存地址，用户不知道我们有这个假的节点，现在我们的链表都有前一个节点(index为0的位置的节点的前一个节点即是虚拟头节点)
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
     * 在链表的index(0-based)位置添加新的元素e
     * 此方法在链表中不是一个常用的操作，练习用
     * 添加的时候，从index为0的前一个节点，即虚拟头节点开始
     */
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
            Node prev=dummyHead;  //前一个 从虚拟头节点开始
             // dummyHead是0这个索引位置的元素他之前的那个节点，现在我们要找到的是index索引位置的前那个节点
             //TODO 我们是从dummyHead这个节点位置开始遍历的
            for (int i = 0; i < index; i++){  //找到你要遍历的元素的前一个节点 理解index  而不是index-1 !!!
                prev=prev.next;
            }
         // System.out.println("#########"+prev.next);  //添加头节点的时候，这里的输出的prev.next值为null ，即dummyHead的next初始值为null
            prev.next = new Node(e, prev.next); //指针指向新的节点
         // System.out.println("+++++++++"+prev.next);  //添加头节点的时候，这里的prev.next的值是新节点在内存中的地址
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
     * 查询的时候，从index为0的节点开始
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
            Node cur=dummyHead.next; //当前 从index为0的位置开始
        //TODO  从dummyHead的下一个节点开始，也就是从index索引为0的位置开始遍历  注意与上面的 Node prev=dummyHead;不同，需要理解
            for (int i = 0; i < index; i++) {
                cur =cur.next;
                //遍历获得到index位置的节点，等号左边的cur是index前一个节点
                //cur.next得到的是cur的下一个节点也就是index节点的内存地址，将index内存地址赋值给cur，即cur节点指针指向了index节点，即此时出了循环的cur即为index位置的节点
            }
            return cur.e;   //index节点的元素
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
     * 修改的时候，从index为0的节点开始
     */
    public void set(int index,E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Illegal index");
        }
        Node cur=dummyHead.next;  //当前节点cur为index为0的节点
        for (int i = 0; i < index; i++) {
            cur =cur.next;  //指向位置改变了
        }
        cur.e=e;  //修改index节点的元素值
    }

    /**
     * 查找元素中是否有元素e
     * 查询的时候，从index为0的节点开始
     */
    public  boolean contains(E e) {
        Node cur =dummyHead.next; //从index为0的位置开始
        while (cur != null) {    //TODO 注意这里的写法！！ 末尾的节点的引用一般为null，此处意思是当引用不为空,即下一个节点不存在，一直循环每个节点进行比较
            if (cur.e.equals(e)) {  //泛型比较，使用equals
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //从头节点开始的写法
    public boolean contains2(E e) {
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.e.equals(e)){
                return true;
            }
            prev=prev.next;
        }
        return false;

    }

    /**
     *
     * 在链表中删除index(0-based)位置的元素,并返回删除的元素
     * 删除的时候，从index为0的前一个节点，即虚拟头节点开始
     */
    public  E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Illegal index");
        }
        Node prev =dummyHead; //从虚拟头节点开始，即虚拟头节点的位置为index=0;
        //找到待删除的索引之前的一个节点
        for (int i = 0; i < index; i++) {
            prev =prev.next;
        }
        //这里循环遍历完得到的是index位置的前一个节点
        Node retNode =prev.next;  //retNode 返回的节点
        prev.next=retNode.next;
        retNode.next=null;  //垃圾回收 index这个要删除的节点，使指针置为空，彻底和链表脱离
        size--;
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
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     * 删除的时候，从index为0的前一个节点，即虚拟头节点开始
     */
    public void removeElement(E e) {
        Node prev =dummyHead;  //从虚拟头节点开始
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;  //找到元素e,跳出循环
            }
            prev = prev.next; //否则继续找下一个进行比较
        }

        if (prev.next != null) {   //这个判断是啥子意思？？
            Node delNode =prev.next;  //要删除的节点 delNode
            prev.next = delNode.next; //改变指针指向
            delNode.next =null;  //删除的节点脱离链表，进行垃圾回收
            size--;
        }
    }


    /**
     * 遍历链表
     * 查询的时候，从index为0的节点开始
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

           Node cur =dummyHead.next; //从index为0的位置开始
           while (cur != null) { //节点不为空
            res.append(cur + "->");  //当前节点 -> 下一个节点 进行拼接
            cur =cur.next;
        }

        //while也可以用for循环
//        for(Node cur =dummyHead.next; cur != null; cur =cur.next){
//            res.append(cur + "->");
//            res.append("NULL");
//        }
        res.append("NULL"); //最后一个节点的指针指向的是null
        return res.toString();
    }

  /** 分析时间复杂度 增删改查的时间复杂度都是O(n) */
  public static void main(String[] args) {
    //
        LinkedList2<String> linkedList=new LinkedList2<>();
        linkedList.add(0,"666");
     //  System.out.println(linkedList.get(0));
  }
}

