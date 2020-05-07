package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo2;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: https://blog.csdn.net/tfygg/article/details/51638933
 */
public class Test {
    public static void main(String[] args) {

        // 事件源（被监听的对象）
        EventSource m1 = new EventSource();
        EventSource2 m2 = new EventSource2();
        // 监听器  TODO 如果有些场合，只需要临时需要创建一个接口的实现类，就可以使用匿名类直接new接口
        IEventListener mEventListener = new IEventListener() {

            @Override
            public void doEvent(IEvent arg) {
                if (true == arg.ClickButton()) {
                    System.out.println("你点击了按钮");
                }else if(true == arg.MoveMouse()){
                    System.out.println("你移动了鼠标");
                }
            }
        };

        // 注册监听器到事件源
        m1.setEventListener(mEventListener);
        m1.mouseEventHappened();

        // 注册监听器到事件源
        m2.setEventListener(mEventListener);
        m2.buttonEventHappened();
    }
}