package com.datastructure.learning.basicTest.多态.demotest4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-06
 * @description:
 */
public class Test {

    public static void test(){
        //        Hello h = new Hello("World");
//        System.out.println(h.hello());
//
        //接口也是一种数据类型，适用于向上转型和向下转型 这里List继承了Collection接口，Collection接口继承了Iterable接口，而ArrayList实现了List接口也就继承了list接口的所有方法
        List list = new ArrayList<>();
        Collection coll=list;
        Iterable it=coll;

        Person p= new Person("小明",16);
        Student s = new Student("小红",17);
        p.play();//person--我的名字是：中国人
        s.play();//student--我的名字是：湖北人

        System.out.println("================================================");
        Student s1=new Student("小红",17,100);
        s1.learn();
        System.out.println(s1);  //com.example.Demo.Demo.Student@28a418fc 没有重写toString方法，打印的这个就是s1在jvm中的内存地址
        s1.toString();//方法重写
        System.out.println(s1.hello());//方法重写
        s1.setSource(200);
        System.out.println(s1.getSource());
        s1.setSource(200,300);//方法的重载
        System.out.println(s1.getSource());



        System.out.println("================================================");
//        Person ps = new Student("湖北"); //向下转换
//        ps.play();
        Person ps = s;
        s.play(); //student--我的名字是：湖北人
        System.out.println("================================================");
//        Student st = (Student) new Person("中国");//这样不能转换？？
//        st.play();

        //强制向下转型，最好借助instanceof判断
        if (p instanceof Student) { //p对象不是Student类或者他的子类的实例
            Student s2 = (Student) p;
            s2.play();
        } else {
            System.out.println("p不是Student类或者他的子类的实例");  //打印输出 考察 instanceof 的用法
        }
        System.out.println("================================================");

        Student st2 = (Student) ps;//可以这样向上转换，进行向上转换必须之前要进行一次向下转换？？？
        st2.play();//student--我的名字是：湖北人

    }

    public static void main(String[] args) {

        test();

//
//        //多态的表现：对象造型--用父类型引用引用子类型对
//        //象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为
//        Person pp=new Student("张三",18);
//        Person pp2=new Worker("李四",19);
//
//
//        System.out.println( pp.hello());  //hello ,world!!! 输出多结果为子类重写的父类的方法
//        System.out.println( pp2.hello());
//






    }
}
