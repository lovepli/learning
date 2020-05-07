package com.datastructure.learning.basicTest.设计模式.建造者模式.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: Admin指导建造者创建User(Director)
 */
public class Admin {

    private AdminBuilder adminBuilder;

    public void setAdminBuilder(AdminBuilder adminBuilder) {
        this.adminBuilder = adminBuilder;
    }
    public User makeUser(String id,String name,String password,String phone){
        adminBuilder.makeId(id);
        adminBuilder.makeName(name);
        adminBuilder.makePassword(password);
        adminBuilder.makePhone(phone);
        return this.adminBuilder.makeUser();
    }
}