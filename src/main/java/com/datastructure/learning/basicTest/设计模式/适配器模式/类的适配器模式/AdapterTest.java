package com.datastructure.learning.basicTest.设计模式.适配器模式.类的适配器模式;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description: 类的适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();   //Source的方法
        target.method2();  //Adapter 重写接口的方法

        if(target instanceof Adapter){
            target.method2();
        }
        if(target instanceof Source){
            target.method1();
        }

       // target.test(); 受检查报错，不能执行Adapter的test方法，只能执行method1和method2方法，说明target 是Targetable对象
      //  target.test2(); 受检查报错，不能执行 Source的test2方法，只能执行method1和method2方法，说明target 是Targetable对象
    }
}
