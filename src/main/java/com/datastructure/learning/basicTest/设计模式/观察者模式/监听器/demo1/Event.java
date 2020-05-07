package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 事件载体：Event
 */
public interface Event extends Serializable {

    /**
     * 事件源
     * @return
     */
    Object getSource();

    /**
     * 事件发生时间
     * @return
     */
    Date getWhen();

    /**
     * 事件主题消息，即希望通过事件传递出去的信息
     * @return
     */
    String getMessage();

    /**
     * 事件回调方法
     */
    void callback();
}
