package com.datastructure.learning.basicTest.设计模式.建造者模式.注解链式.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  有继承的类使用链式建造者模式
 */
public class Test {

    public static void main(String[] args) {

        Student student = Student.builder()
                .schoolName("清华附小")
                .grade("二年级")
                .weight(10)
                .height(10)
                .build();

        // Student(super=Person(weight=10, height=10), schoolName=清华附小, grade=二年级)
        System.out.println(student.toString());
    }


    /**
     * Guava Cache框架中用到了链式
     *
     * Cache<String,String> cache = CacheBuilder.newBuilder()
     *         .maximumSize(2)
     *         .expireAfterWrite(3,TimeUnit.SECONDS)
     *         .build();
     */
}
