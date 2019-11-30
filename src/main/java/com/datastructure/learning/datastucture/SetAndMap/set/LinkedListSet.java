package com.datastructure.learning.datastucture.SetAndMap.set;

import com.datastructure.learning.datastucture.LinkedList.LinkedList; //引入自己封装的LinkedList

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 底层使用链表来实现Set集合  LinkedList特点：动态的
 */
public class LinkedListSet<E> implements  Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list =new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e) {  //注意链表元素要去重！！！

        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 时间复杂度分析
     *
     * 增：O(n)
     * 删：O(n)
     * 查：O(n)
     *
     *
     */
}
