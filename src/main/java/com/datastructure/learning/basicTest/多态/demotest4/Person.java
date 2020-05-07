package com.datastructure.learning.basicTest.多态.demotest4;

/**
 * @author: lipan
 * @date: 2019-06-06
 * @description:
 */
public class Person {

    protected String name;   //protected 允许子类访问夫类的字段和方法

    public  int age;

    public Person() {
        //初始化给属性赋值，也可以在protected String name="xiao ming"； 的时候进行赋值
        //this.name="xiao ming";
       // this.age=25;
        this("xiao ming",25);//调用有参构造方法

    }

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();  //检测并删除用户填写的名字出错 例如Person p=new Person(); p.setName("  小明") 这里的空格就可以在setName()方法调用的时候删除
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void play() {
        System.out.println("person--我的名字是："+this.name+" ，我的年龄是："+this.age);

    }

    protected String hello() {
        return "hello ,world";
    }


//    @Override
//    public String toString() {
//        return "Person:"+this.name+", "+this.age;
//    }

    /**
     * final关键字：
     * 1。final修饰的方法不能被Override
     * 2.final修饰的类不能被继承
     * 3。final修饰的字段在初始化后不能被修改
     */
}
