package com.datastructure.learning.basicTest.设计模式.建造者模式.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 具体建造者(BuilderImpl)
 */
public class AdminBuilder implements Build{

    User user=new User();

    @Override
    public User makeUser(){
        return user;
    }
    @Override
    public void makeId(String val) {
        user.setId(val);
    }
    @Override
    public void makeName(String val) {
        user.setName(val);
    }
    @Override
    public void makePassword(String val) {
        user.setPassword(val);
    }
    @Override
    public void makePhone(String val) {
        user.setPhone(val);
    }
}
