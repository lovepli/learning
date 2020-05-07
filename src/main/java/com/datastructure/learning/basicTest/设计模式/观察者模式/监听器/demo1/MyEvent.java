package com.datastructure.learning.basicTest.设计模式.观察者模式.监听器.demo1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 事件实现：MyEvent
 */
public class MyEvent implements Event {

     //记录日志的两种方法
    private  Log log = LogFactory.getLog(getClass());
    // static修饰的变量在内存中保存唯一份 TODO 定义一个能在该类所有对象中共享的变量log2
    private static  Log log2 = LogFactory.getLog(MyEvent.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    //事件源
    private Object source;

    //事件发生时间
    private Date when;

     //事件主题消息，即希望通过事件传递出去的信息
    private String message;

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    @Override
    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void callback() {
        //事件回调
        log.info(toString());
    }

    @Override
    public String toString() {
        return "source: " + getSource() + ", message: " + getMessage() + ", when: " + sdf.format(getWhen());
    }
}