package com.datastructure.learning.datastucture.BinarySearchTree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 二分搜索树 后面还有一个BST是实现映射的BST，注意区别
 */
public class BST<E extends Comparable<E>> { //具有可比较性 E必须是可以表的 所以继承Comparable

    private class Node{
        public E e;
        public Node left, right; //左右孩子

        public Node(E e) {
            this.e=e;
            left=null;
            right=null;
        }
    }

    private Node root; //根节点
    private int size;

    public BST() {
        root =null;
        size =0;
    }

    /**
     *
     * @return
     */
    public int size() {
        return  size;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *向二分搜索树中添加新的元素 public方法add
     * @param e
     */
    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add1(root,e); //递归函数
        }
    }


    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * @param node
     * @param e
     *   注意此处是private的add方法 !!!
     */
    private void add1(Node node, E e) {
        //递归的终止条件 和逻辑
        if (e.equals(node.e)) { // TODO 由于不是基本类型的，所以不能直接用 == 比较？？？????????
            return; //插入元素与节点元素等于直接返回 e.equals(node.e) 与e.compareTo(node.e)== 0 写法结果是否相同？？？？
        } else if (e.compareTo(node.e)<0 && node.left == null) {   //这里比较使用的是compareTo()
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e)>0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }

        if (e.compareTo(node.e) < 0) { //插入元素小于节点元素
            add1(node.left, e);
        } else { //e.compareTo(node.e) > 0
            add1(node.right,e);
        }

    }

    //======================简化代码逻辑========================

    /**
     * 向二分搜索树中添加新的元素(简化版) public方法add
     */
    public void add(E e) {
        root = add(root,e);//调用新的函数进行递归
    }

    /**
     *向以node为根节点的二分搜索树中插入元素e，递归算法(简化版)
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left,e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     */
    public  boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        else{ //e.compareTo(node.e) > 0   注意if 与else if 和else的用法区别
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     * 原理：先中，再左，最后右
     */

    public void preOrder() {
        preOrder(root);

    }

    /**
     * 前序遍历以node为根的二分搜索树树，递归算法
     * @param node
     */
    private void preOrder(Node node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的非递归前序遍历 使用stack来遍历元素
     * 看懂并理解视频里面的原理，主要用的就是stack的性质 巧妙使用栈来记录之后需要遍历的元素
     */
    public void preOrderNR() {//非递归前序遍历

       Stack<Node> stack =new Stack<>();  //这里我们使用的引入是Java API中的stack 也可以使用我们自己写的数组栈或者链表栈来实现
       // LinkedListStack<Node> stack=new LinkedListStack<>(); //使用自己写的这个报错了？？？？
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur =stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }



    /**
     * 中序遍历以node为根的二分搜索树树，递归算法
     * 中序遍历也叫做排序树  得到的所有元素是顺序排序的结果
     * 原理：先访问这个节点的左子树，然后访问这个节点的元素，最后访问这个节点的右子树
     * @return
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历以node为根的二分搜索树树，递归算法
     * 原理：先左，再右，最后中
     * 一个典型的应用场景：在内存的释放方面，为二分搜索树释放内存 （手动控制内存，先把该节点的孩子节点释放完，再释放该节点本身）
     * @return
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     * @return
     */
    public void levelOrder() {
        Queue<Node> q=new LinkedList<>();  //Queue队列的具体的实现为链表的数据结构 这里引入Java API自己的数据结构 也可以使用我们自己写的链表队列
       // LinkedListQueue<Node> q=new LinkedListQueue<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur =q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小值
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is em[ty!");
        }
        return minimum(root).e;
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
     * 寻找二分搜索树的最大值
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is em[ty!");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right =null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     *从二分搜索树中删除最大值所在的节点，返回最大值
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left =null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @return
     */
    public void remove(E e) {
        root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left=remove(node.left,e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e == node.e

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



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res); //格式化打印输出的字符串
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node == null) {
            res.append(generateDepthtring(depth) + "null\n");
            return;
        }
        res.append(generateDepthtring(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);

    }

    /**
     *
     */
    private String generateDepthtring(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--"); //深度显示
        }
        return res.toString();
    }


}
