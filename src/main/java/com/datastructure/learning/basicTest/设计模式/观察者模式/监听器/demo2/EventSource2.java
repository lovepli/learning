package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo2;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class EventSource2 implements IEvent {
    private IEventListener ml;
    boolean button;
    boolean mouse;

    //注册监听器
    @Override
    public void setEventListener(IEventListener arg) {
        ml = arg;
    }

    // 触发事件
    public void buttonEventHappened() {
        button = true;
        ml.doEvent(this);
    }

    @Override
    public boolean ClickButton() {
        // TODO Auto-generated method stub
        return button;
    }

    @Override
    public boolean MoveMouse() {
        // TODO Auto-generated method stub
        return mouse;
    }



}