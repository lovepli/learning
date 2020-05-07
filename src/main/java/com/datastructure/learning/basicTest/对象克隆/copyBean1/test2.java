package com.datastructure.learning.basicTest.对象克隆.copyBean1;



/**
 * @author: lipan
 * @date: 2020-03-04
 * @description: 深拷贝的实现方式1 :实现序列化接口
 */
public class test2 {

    public static void main(String[] args) {

        DemoInternal2 di=new DemoInternal2();
        di.setInternalName("66");
        di.setInternalValue("77");

        Demo2 d1=new Demo2();
        d1.setName("哈哈");
        d1.setValue("呵呵");
        d1.setDemoInternal2(di);

        Demo2 d2=CloneUtils.clone(d1);  //TODO 深拷贝的实现
        Demo2 d3=d1;
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
        System.out.println(d3);//Demo{name='ddddd', value='bbbbb', Demo

    }
}
