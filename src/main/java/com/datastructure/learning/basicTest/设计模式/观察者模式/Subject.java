package com.datastructure.learning.basicTest.设计模式.观察者模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */

public interface Subject {
    /*增加观察者*/
    public void add(Observer observer);

    /*删除观察者*/
    public void del(Observer observer);
    /*通知所有的观察者*/
    public void notifyObservers();
    /*自身的操作*/
    public void operation();
}
