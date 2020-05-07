package com.datastructure.learning.basicTest.设计模式.观察者模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}

