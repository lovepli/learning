package com.datastructure.learning.basicTest.设计模式.工厂模式.抽象工厂模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:   提供产生工厂类的接口，方便扩展
 */
public interface Provider {
    public Sender produce();
}
