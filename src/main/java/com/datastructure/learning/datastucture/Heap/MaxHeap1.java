package com.datastructure.learning.datastucture.Heap;


import com.datastructure.learning.datastucture.Array.Array;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 最大堆 底层用数组存储二叉堆
 * 弃用原因：进行堆测试出问题，可能是代码有问题，但是可以看注释理解逻辑
 */
public class MaxHeap1<E extends Comparable<E>> {


    private Array<E> data;

    public MaxHeap1(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap1() {
        data = new Array<>();
    }

    public MaxHeap1(E [] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i++) {
            siftDown(i);
        }


    }

    /**
     * 返回堆中元素个数
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回一个布尔值，表示堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("index-0 does not have parent.");
        }
        return (index - 1) / 2;  //从0开始，索引为index-1
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加·元素
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);

    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中最大元素
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     */
    public E extractMax() {

        E ret =findMax();

        data.swap(0,data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return ret;
    }

    /**
     * 下沉
     * @param k
     */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                //data[j] 是leftChjild 和rightChild 中的最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素，并且替换成元素e
     * @param e
     * @return
     * replace实现方法：取出最大元素，放入到一个新的元素
     * 方式一：可以先extractMax,再add,两次O(log(n))的操作
     * 方式二：可以直接将堆顶元素替换以后siftDown,一次O(log(n))的操作
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }




}
