package com.datastructure.learning.datastucture.SetAndMap.map;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 基于BST二分搜索树实现映射Map
 */
public class BSTMap<K extends Comparable<K> ,V > implements Map<K ,V> {  //二分搜索树对于key必须是可以比较的

    private class Node{
        //存储k-value 数据对，之前二分搜索树只是存储一个E的元素 ,现在将存一个E换成存两个元素
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            left =null;
            right =null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
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
     * 向二分搜索树中添加新的元素 (key-value）数据对   // TODO Java API中将set更新和add添加统一用put放置替代
     */
    public void add(K key,V value) {
        root=add(root,key,value);

    }

    /**
     * 向以node为根的二分搜索树中插入与元素(key,value)数据对，递归算法
     *返回插入新节点后二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node,K key,V value) {

        if (node == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { //key.compareTo(node.key) == 0
            node.value =value; //这里默认替换新的value值，注意理解
        }
        return node;
    }

    /**
     * 返回以node为根节点的二分搜索树中，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else{// (key.compareTo(node.key) > 0)  //这里不能再用 else if
            return getNode(node.right, key);
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "does not exit!");
        }
        node.value = newValue;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除以node为根节点的二分搜索树中最小的节点
     * 返回删除节点后的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null) {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    /**
     * 删除掉以node为根节点的二分搜索树中键为key的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { //key.compareTo(node.key) == 0

            //待删除的节点右子树为空的情况
            if (node.left == null) {
                Node rightNode=node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除的节点左子树为空的情况
            if (node.right == null) {
                Node leftNode=node.left;
                node.left =null;
                size --;
                return leftNode;
            }

            //待删除的节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的蕞小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left=node.left;

            node.left =node.right =null;

            return successor;
        }
    }

    /**
     * 时间复杂度分析
     *
     * 增add：       O(h)
     * 删remove：    O(h)
     * 查get：       O(h)
     * 改set：       O(h)
     * 查contains：  O(h)
     *
     * h:高度 层  第h层有2^(h-1)个节点  所以h层一共有2^h-1 个节点
     *
     * 所以二分搜索树的复杂度为：
     * 增：O(h) -> O(log(n))
     * 删：O(h) -> O(log(n))
     * 查：O(h) -> O(log(n))
     * 改：O(h) -> O(log(n))
     *
     */

}
