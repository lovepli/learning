package com.datastructure.learning.datastucture.SetAndMap.map;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 映射 支持泛型K，V
 */
public interface Map<K,V> {

    void add(K key,V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newVlaue);

    int getSize();

    boolean isEmpty();
}
