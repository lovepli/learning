package com.datastructure.learning.datastucture.SetAndMap.set;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 集合
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
