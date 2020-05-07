package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo2;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
/*
 * 事件源：事件发生的地点
 */
public class EventSource implements IEvent{
    private IEventListener mEventListener;
    boolean button;
    boolean mouse;

    //注册监听器
    @Override
    public void setEventListener(IEventListener arg){
        mEventListener = arg;
    }

    //触发事件
    public void mouseEventHappened(){
        mouse = true;
        //处理事件
        mEventListener.doEvent(this);
    }

    @Override
    public boolean ClickButton() {
        return button;
        // TODO Auto-generated method stub

    }

    @Override
    public boolean MoveMouse() {
        // TODO Auto-generated method stub
        return mouse;
    }

}