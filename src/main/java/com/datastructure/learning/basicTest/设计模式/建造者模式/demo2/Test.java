package com.datastructure.learning.basicTest.设计模式.建造者模式.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 什么是建造者模式？
 * 建造者模式是一种创建型模式，
 * 建造者模式将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创造不同的表示。建造对象的时候只需要指定需要建造的类型，而不必了解具体的建造过程。
 * 主要特点是通过逐步添加单体对象形成一个复杂的对象。
 */
public class Test {

    public static void main(String[] args){
        AdminBuilder adminBuilder=new AdminBuilder(); //new 具体建造者
        Admin admin=new Admin();  //new出Admin指导建造者
        admin.setAdminBuilder(adminBuilder);  //准备开始建造(不写会报空指针)
        User user=admin.makeUser("1","张三","123456","88888888"); //根据Admin的建造方法创建User
        System.out.println(user.toString());
    }
}
