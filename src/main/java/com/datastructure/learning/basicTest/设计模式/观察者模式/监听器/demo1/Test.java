package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 事件流转过程：
 *
 * （1）事件源注册监听器 -> （2）事件发生 -> （3）通知监听器 -> （4）监听器处理
 *
 * 总结：
 * 监听器模式和观察者模式看起来很像，不过在事件模型的设置上有些许差别。
 * 在观察者模式中并没有Event这个角色，或者说它被合并到Observable角色中了，即整合了事件源与事件。
 */
public class Test {

    public static void main(String[] args) {
        MySource source = new MySource();
        //1、事件源注册监听器
        source.addListener(new MyListener());
        //2、事件发生--设置传递消息内容的时候就通知了监听器执行
        source.setValue(100);
    }
}
