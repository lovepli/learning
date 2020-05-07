package com.datastructure.learning.basicTest.多态.demotest4;

/**
 * @author: lipan
 * @date: 2020-04-09
 * @description:
 */
public class Worker extends Person {

    private int source;  //避免保罗field 但是可以通过public方法间接的访问修改field的值，这里public setSource()方法可以修改field值


    public Worker(String name, int age) {
        super(name,age);
    }

    public Worker(String name, int age,int source) {
        super(name,age);
        this.source=source;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    //方法的重载 ：多个方法的方法名相同，但各自的参数不同（参数个数不同，参数类型不同，参数为位置不同），方法的返回值类型通常相同 重载的目的；相同功能的方法使用同一个名字，便于调用   重载的方法功能要相同！！！
    public void setSource(int eglishSource,int mathSource) {
        this.source = eglishSource+mathSource; //分数之和 传入两个参数，返回的分数是数学和英语分数之和
    }


    @Override
    public void play() {
        System.out.println("student--我的名字是："+this.name+" ，我的年龄是："+this.age);
    }

    //方法重写
    @Override
    public String hello() {
        return super.hello() + "，好好工作！！！！";
    }


    protected void learn() {
        System.out.println("student--我的名字是："+this.name+" ，我的年龄是："+this.age+" ，我的分数为："+this.source);
    }


    @Override
    public String toString() {
        return "Student:"+this.name+", "+this.age+" ,"+this.source;
    }
}
