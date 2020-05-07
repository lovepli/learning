package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo2;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
/*
 * 事件监听器，调用事件处理器
 */
public interface IEventListener {

    void doEvent(IEvent arg);
}