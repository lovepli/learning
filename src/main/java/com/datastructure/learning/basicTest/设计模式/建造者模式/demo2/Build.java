package com.datastructure.learning.basicTest.设计模式.建造者模式.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 抽象建造者/建造者接口(Builder)
 */
public interface Build {
    void makeId(String val);
    void makeName(String val);
    void makePassword(String val);
    void makePhone(String val);
    User makeUser();
}