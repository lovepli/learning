package com.datastructure.learning.basicTest.final关键字;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Demo {

    /**
     * final关键字在java中使用非常广泛，可以申明成员变量、方法、类、本地变量。
     * 一旦将引用声明为final，将无法再改变这个引用。final关键字还能保证内存同步
     */

    /**
     * final关键字的知识点
     * final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。final变量一旦被初始化后不能再次赋值。
     * 本地变量必须在声明时赋值。 因为没有初始化的过程
     * 在匿名类中所有变量都必须是final变量。
     * final方法不能被重写, final类不能被继承
     * 接口中声明的所有变量本身是final的。类似于匿名类
     * final和abstract这两个关键字是反相关的，final类就不可能是abstract的。
     * final方法在编译阶段绑定，称为静态绑定(static binding)。
     * 将类、方法、变量声明为final能够提高性能，这样JVM就有机会进行估计，然后优化。
     * final方法的好处:
     *
     * 提高了性能，JVM在常量池中会缓存final变量
     * final变量在多线程中并发安全，无需额外的同步开销
     * final方法是静态编译的，提高了调用速度
     * final类创建的对象是只可读的，在多线程可以安全共享
     */

    /**
     * final与static final的区别是：final在一个对象类唯一，static final在多个对象中都唯一；
     * 一个既是static又是final的域只占据一段不能改变的存储空间，只有一份
     *
     * 使用static和final的情况：
     * 1、你定义一个常量
     * 2、定义一个能在该类所有对象中共享的变量。 比如Log
     * 3、用静态工厂方法来创建对象
     * 4、一些工具类，提供static方法，使用的时候不需要new，方便调用
     * 5、一个类的内部定义static内部类，比如Builder模式。
     * 6、。。。。
     */
}
