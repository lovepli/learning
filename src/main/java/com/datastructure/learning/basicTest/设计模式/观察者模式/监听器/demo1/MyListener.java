package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 监听器实现：MyListener
 */
public class MyListener implements EventListener {

    @Override
    public void handleEvent(Event event) {
        //事件回调
        event.callback();
    }
}
