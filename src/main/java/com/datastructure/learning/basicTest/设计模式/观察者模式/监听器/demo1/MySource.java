package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 编写测试的事件源：MySource
 */
public class MySource implements EventSource {

    private List<EventListener> listeners = new ArrayList<EventListener>();

    //消息内容
    private int value;

    /**
     * 注册监听器
     * @param listener
     */
    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    /**
     * 通知监听器
     */
    @Override
    public void notifyListener() {
        for (EventListener listener : listeners) {
            MyEvent event = new MyEvent();
            //事件源
            event.setSource(this);
            //事件时间
            event.setWhen(new Date());
            //消息主题内容
            event.setMessage("setValue " + value);

            //4、监听器处理--事件触发
            listener.handleEvent(event);
        }
    }

    public int getValue() {
        return value;
    }

    //设置事件主题消息，即希望通过事件传递出去的信息
    public void setValue(int value) {
        this.value = value;
        //3、通知监听器
        notifyListener();
    }

}
