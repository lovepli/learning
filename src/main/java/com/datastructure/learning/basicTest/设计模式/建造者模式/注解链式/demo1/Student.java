package com.datastructure.learning.basicTest.设计模式.建造者模式.注解链式.demo1;

import lombok.Builder;
import lombok.Data;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  没有继承的情况
 * 使用Lombok中@Builder的注解实现链式反应
 */
@Data
@Builder
public class Student {

    private String name;
    private int age;
    private int gender;
}