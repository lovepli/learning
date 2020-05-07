package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 事件源接口：EventSource
 */
public interface EventSource {

    /**
     * 增加/注册监听器
     * @param listener
     */
    void addListener(EventListener listener);

    /**
     * 通知监听器
     */
    void notifyListener();
}