package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 监听器接口：EventListener
 */
public interface EventListener {

    /**
     * 事件触发
     * @param event
     */
    void handleEvent(Event event);
}
