package com.datastructure.learning.datastucture.SetAndMap.map;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 基于LinkedLis链表的底层数据结构实现映射类
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{ //私有内部类
        public K key;
        public V value; //存储k-value 数据对，之前链表只是存储一个E的元素，现在将存一个E换成存两个元素
        public Node next;

        public Node(K key,V value,Node next){
            this.key =key;
            this.value = value;
            this.next=next;
        }

        public Node(K key) {
            this(key,null,null);
        }

        public Node() {
          this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString() + ":"+value.toString();
        }
    }

    private Node dummyhead; //虚拟头节点
    private int size;

    public LinkedListMap() {
        dummyhead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    /**
     *   借助辅助函数 私有新建的
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur =dummyhead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) !=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 向链表中添加key-value数据对
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node == null) {
            dummyhead.next = new Node(key, value, dummyhead.next);
            size++;
        } else {
            node.value = value;  //这里如果新添加的key重复了，那么value值将被新的值覆盖更新，我们也可以在这里设计抛出一个异常，提醒用户你添加的key重复了
        }
    }

    /**
     * 修改
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "does not exist!");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key) {

        Node prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)){
                break;
            }
            prev=prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    /**
     * 时间复杂度分析
     *
     * 增add：       O(n)
     * 删remove：    O(n)
     * 查get：       O(n)
     * 改set：       O(n)
     * 查contains：  O(n)
     *
     *
     */

}
