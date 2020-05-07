package com.datastructure.learning.basicTest.设计模式.建造者模式.注解链式.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  有继承的情况
 * 1.对于父类，使用@AllArgsConstructor注解
 * 2.对于子类，手动编写全参数构造器，内部调用父类全参数构造器，在子类全参数构造器上使用@Builder注解
 */
@Data
@AllArgsConstructor
public class Person {

    private int weight;
    private int height;
}
