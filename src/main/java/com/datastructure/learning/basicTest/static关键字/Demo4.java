package com.datastructure.learning.basicTest.static关键字;

import java.net.HttpURLConnection;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:  建造者模式中使用静态内部类
 */
public class Demo4 {

    public static void main(String[] args) {
        // 在需要创建Person对象的时候   //创建静态内部类对象的方式 new 外部类.内部类
        Person person = new Person.Builder().name("张三").age(17).build();

    }

}

class Person {
    private String name;
    private int age;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

     static class Builder {

        private String name;
        private int age;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder age(int age) {
            this.age=age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * 第二种情况一般出现在多线程场景下，非静态内部类可能会引发内存溢出的问题，比如下面的例子：
 * 声明并创建了一个匿名内部类对象，该对象持有外部类Task实例的引用，如果在在run方法中做的是耗时操作，
 * 将会导致外部类Task的实例迟迟不能被回收，如果Task对象创建过多，会引发内存溢出。
 */
class Task {

    public void onCreate() {
        // 匿名内部类, 会持有Task实例的引用
        new Thread() {
            public void run() {
                //...耗时操作
            };
        }.start();
    }
}

/**
 *优化方式
 */
class Task2 {

    public void onCreate() {
        SubTask subTask = new SubTask();
        subTask.start();
    }

    static class SubTask extends Thread {
        @Override
        public void run() {
            //...耗时操作
        }

    }
}

