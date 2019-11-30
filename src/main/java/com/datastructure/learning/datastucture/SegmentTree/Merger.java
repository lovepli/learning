package com.datastructure.learning.datastucture.SegmentTree;

/**
 * @author: lipan
 * @date: 2019-06-03
 * @description: 设置融合器接口，处理两个参数，返回一个数回去
 * 两个区间是怎么融合的
 */
public interface Merger<E> {
    E merge(E a, E b);
}
