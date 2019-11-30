package com.datastructure.learning.datastucture.SetAndMap.set;

import com.datastructure.learning.datastucture.BinarySearchTree.BST;  //引入自己写的二分搜索树

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 基于二分搜索树BST实现Set集合 BST二分搜索树的特点：动态的，不存储重复元素
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E>  bst;

    public BSTSet() {
        bst=new BST<>();
    }

    @Override
    public int getSize() {
         return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {  //不能添加重复的元素，二分搜索树刚好不存重复元素
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 时间复杂度分析
     *
     * 增：O(h)
     * 删：O(h)
     * 查：O(h)
     *
     * h:高度 层  第h层有2^(h-1)个节点  所以h层一共有2^h-1 个节点
     *
     * 所以二分搜索树的复杂度为：
     * 增：O(h) -> O(log(n))
     * 删：O(h) -> O(log(n))
     * 查：O(h) -> O(log(n))
     */
}
