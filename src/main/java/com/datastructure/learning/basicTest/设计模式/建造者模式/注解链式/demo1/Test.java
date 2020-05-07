package com.datastructure.learning.basicTest.设计模式.建造者模式.注解链式.demo1;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 *  参考：https://www.javazhiyin.com/41418.html
 *
 *  没有继承的类使用链式建造者模式
 */
public class Test {

    public static void main(String[] args) {
        Student student = Student.builder()
                .name("小明")
                .age(10)
                .gender(1)
                .build();
        // Student(name=小明, age=10, gender=1)
        System.out.println(student);
    }
}
