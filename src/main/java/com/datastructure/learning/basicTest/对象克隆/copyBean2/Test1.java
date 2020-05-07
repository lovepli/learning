package com.datastructure.learning.basicTest.对象克隆.copyBean2;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description: 深拷贝的实现方式1 :clone()方法
 *  * 浅拷贝：被复制对象的所有值属性都含有与原来对象的相同，而所有的对象引用属性仍然指向原来的对象。
 *  *
 *  * 深拷贝：在浅拷贝的基础上，所有引用其他对象的变量也进行了clone，并指向被复制过的新对象。
 *  *
 *  * 也就是说，一个默认的clone()方法实现机制，仍然是赋值。
 *  *
 *  * 如果一个被复制的属性都是基本类型，那么只需要实现当前类的cloneable机制就可以了，此为浅拷贝。
 *  *
 *  * 如果被复制对象的属性包含其他实体类对象引用，那么这些实体类对象都需要实现cloneable接口并覆盖clone()方法。
 */
public class Test1 {

    public static void main(String[] args) {
        DemoInternal di=new DemoInternal();
        di.setInternalName("66");
        di.setInternalValue("77");

        Demo d1=new Demo();
        d1.setName("哈哈");
        d1.setValue("呵呵");
        d1.setDemoInternal(di);

        Demo d2=d1.clone();  //TODO 深拷贝的实现
        Demo d3=d1;
        System.out.println(d1==d2);//false  //TODO 两个对象
        System.out.println(d1==d3);//true   //TODO 同一个对象
        System.out.println(d1);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d3);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}


        d2.setName("hhh");
        d2.setValue("hehehe");  //TODO 结论：改变克隆对象属性值，原对象属性值不变
        System.out.println(d1);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='hhh', value='hehehe', demoInternal=DemoInternal{internalName='66', internalValue='77'}}

        d1.setName("ddddd");
        d1.setValue("bbbbb");   //TODO 结论：改变原对象属性值,克隆对象属性值不变
        System.out.println(d1);//Demo{name='ddddd', value='bbbbb', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='hhh', value='hehehe', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d3);//Demo{name='ddddd', value='bbbbb', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
    }
}
