package com.datastructure.learning.basicTest.codeTest.demotest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: 测试：Java代码块、构造方法（包含继承关系）的执行顺序
 *
 * 得出结论：
 * 执行顺序依次为：
 * 父类的静态成员和代码块
 * 子类静态成员和代码块
 * 父类成员初始化和代码快
 * 父类构造方法
 * 子类成员初始化和代码块
 * 子类构造方法
 * 注意：可以发现，同一级别的代码块和成员初始化是按照代码顺序从上到下依次执行
 */

@Slf4j
public class Test {
    public static void main(String[] args) {
        new B();
    }
}
