package com.datastructure.learning.basicTest.threadlocal关键字;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description: 将学生信息存入到ThreadLocal中，在同一个线程中，那么直接从ThreadLocal中获取需要的信息即可！案例代码如下所示：
 */
public class ThreadLocalUsage06 {

    public static void main(String[] args) {
        init();
        new NameService2().getName();
        new SexService2().getSex();
        new ScoreService2().getScore();
    }

    private static void init() {
        Student2 student2 = new Student2();
        student2.name = "Lemon";
        student2.sex = "female";
        student2.score = "100";
        //将学生信息存入到ThreadLocal中
        ThreadLocalProcessor.studentThreadLocal.set(student2);
    }

}

class ThreadLocalProcessor {

    public static ThreadLocal<Student2> studentThreadLocal = new ThreadLocal<>();

}

 class Student2 {

    /**
     * 姓名、性别、成绩
     */
    String name;
    String sex;
    String score;

}

class NameService2 {

    public void getName() {
        System.out.println(ThreadLocalProcessor.studentThreadLocal.get().name);
    }

}

class SexService2 {

    public void getSex() {
        System.out.println(ThreadLocalProcessor.studentThreadLocal.get().sex);
    }

}

class ScoreService2 {

    public void getScore() {
        System.out.println(ThreadLocalProcessor.studentThreadLocal.get().score);
    }

}
