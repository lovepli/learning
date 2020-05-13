package com.datastructure.learning.basicTest.反射;

/**
 * @author: lipan
 * @date: 2020-04-15
 * @description:
 *
 * Java 中 的 反 射 首 先 是 能 够 获 取 到 Java 中 要 反 射 类 的 字 节 码 ， 获 取 字 节 码 有 三 种 方 法 ，
 * 1.Class.forName(className)
 * 2.类名.class
 * 3.this.getClass()。
 * 然后将字节码中的方法，变量，构造函数等映射成相应的 Method、 Filed、 Constructor 等类，这些类提供了丰富的方法可以被我们所使用。
 */
public class reflect {

    /**
     * 一、Java反射机制
     * 在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
     * 对于任意一个对象，都能够调用它的任意一个方法和属性。
     * 这种动态获取的信息以及动态调用对象方法的功能成为Java的反射机制。
     *
     * 反射就是把Java类中的各种成分映射成一个个的Java对象。
     * 例如一个类中有成员变量、方法、构造方法、包等信息，利用反射机制可以对一个类进行解剖，把类的组成部分映射成一个个对象。
     * 反射可以在程序运行过程中动态获取类的相关信息，包括类由哪个类加载器进行加载，类中的成员变量，成员方法，访问修饰符，返回值类型，构造方法等。
     *
     * 举例说明JAVA的反射机制的几个主要功能，
     * （1）在运行时判断任意一个对象所属的类obj.getClass()。
     * （2）在运行时构造任意一个类的对象constructor.newInstance(new Object[]{h})。
     * （3）在运行时判断任意一个类所具有的成员变量和方法getDeclaredFields()、getDeclaredMethods()。
     */

}
