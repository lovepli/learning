package com.datastructure.learning.basicTest.内部类.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 局部内部类
 * 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
 * 注意，局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。
 */
public class Test2 {

    //类1
    class People{
        //构造方法
        public People() {

        }
    }

    //类2
    class Man{
        //构造方法
        public Man(){

        }
        //方法
        public People getWoman(){
            //局部内部类3    TODO 内部类的存在湿的Java的多继承机制变得更加完善
            class Woman extends People{
                int age =0;
            }
            return new Woman();
        }
    }
}
