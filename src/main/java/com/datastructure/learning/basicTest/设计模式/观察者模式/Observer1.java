package com.datastructure.learning.basicTest.设计模式.观察者模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
