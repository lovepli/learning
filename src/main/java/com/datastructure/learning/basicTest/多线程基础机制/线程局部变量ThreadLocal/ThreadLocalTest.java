package com.datastructure.learning.basicTest.多线程基础机制.线程局部变量ThreadLocal;

import java.util.Random;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  ThreadLocal实现每一个线程都有自己的专属本地变量
 */
public class ThreadLocalTest implements Runnable {

    ThreadLocal<Student> studenThreadLocal = new ThreadLocal<Student>();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running...");
        Random random = new Random();
        int age = random.nextInt(100); //产生一个100之内的随机整数
        System.out.println(currentThreadName + " is set age: " + age);
        Student student = getStudent(); //通过这个方法，为每个线程都独立的 new 一个 student 对象，每个线程的的 student 对象都可以设置不同的值
        student.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + " is second get age: " + student.getAge());
    }

    private Student getStudent() {
        Student student = studenThreadLocal.get();
        if (null == student) {
            student = new Student();
            studenThreadLocal.set(student);
        }
        return student;
    }

    public static void main(String[] args) {

        ThreadLocalTest t = new ThreadLocalTest();

        Thread t1 = new Thread(t, "Thread A");
        Thread t2 = new Thread(t, "Thread B");
        t1.start();
        t2.start();
    }
}

class Student {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * 3.1. ThreadLocal简介
 * 通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。如果想实现每一个线程都有自己的专属本地变量该如何解决呢？ JDK中提供的ThreadLocal类正是为了解决这样的问题。 ThreadLocal类主要解决的就是让每个线程绑定自己的值，可以将ThreadLocal类形象的比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据。
 *
 * 如果你创建了一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的本地副本，这也是ThreadLocal变量名的由来。他们可以使用 get（） 和 set（） 方法来获取默认值或将其值更改为当前线程所存的副本的值，从而避免了线程安全问题。
 *
 * 再举个简单的例子：
 *
 * 比如有两个人去宝屋收集宝物，这两个共用一个袋子的话肯定会产生争执，但是给他们两个人每个人分配一个袋子的话就不会出现这样的问题。如果把这两个人比作线程的话，那么ThreadLocal就是用来避免这两个线程竞争的。
 */
