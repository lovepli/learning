package com.datastructure.learning.basicTest.设计模式.适配器模式.对象的适配器模式;


/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 对象的适配器模式
 * 基本思路和类的适配器模式相同，只是将 Adapter 类作修改，这次不继承 Source 类，而是持有 Source 类的实
 * 例，以达到解决兼容性的问题。
 */
public class AdapterTest {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }

}


