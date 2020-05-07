package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo2;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
/*
 * 事件
 */
public interface IEvent {

    void setEventListener(IEventListener arg);

    boolean ClickButton();

    boolean MoveMouse();

}