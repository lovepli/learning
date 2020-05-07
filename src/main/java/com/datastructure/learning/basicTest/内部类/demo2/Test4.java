package com.datastructure.learning.basicTest.内部类.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 静态内部类
 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
 * 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，
 * 这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，
 * 如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。
 *
 * 静态内部类是不依赖于外部类的，也就说可以在不创建外部类对象的情况下创建内部类的对象。
 * 另外，静态内部类是不持有指向外部类对象的引用的
 */
public class Test4 {

    public static void main(String[] args) {
        Outter2.Inner2 inner2=new Outter2.Inner2();
    }
}

//外部类
class Outter2 {
    int a=10;
    static int b=5;

    public Outter2() {

    }
    //静态内部类
    static class Inner2 {
        public Inner2() {
            // System.out.println(a);  //报错，不能访问外部类的非static方法
            System.out.println(b);
        }
    }
}