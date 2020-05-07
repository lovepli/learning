package com.datastructure.learning.basicTest.泛型.demo;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:  泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中
 */
//定义一个泛型接口
public interface Generator<T> {
    public T next();
}