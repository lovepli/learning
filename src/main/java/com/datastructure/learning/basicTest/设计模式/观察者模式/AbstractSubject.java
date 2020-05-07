package com.datastructure.learning.basicTest.设计模式.观察者模式;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }
    }
}

