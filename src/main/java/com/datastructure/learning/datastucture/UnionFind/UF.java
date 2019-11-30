package com.datastructure.learning.datastucture.UnionFind;

/**
 * @author: lipan
 * @date: 2019-06-03
 * @description: 并查集  典型案例：连接问题
 * 对于一组数据，主要支持两个动作：union(p,q)  isConnected(p,q)两个元素是否相连
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
