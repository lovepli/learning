package com.datastructure.learning.basicTest.内部类.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description: 匿名内部类
 * 匿名内部类应该是平时我们编写代码时用得最多的，在编写事件监听的代码时使用匿名内部类不但方便，
 * 而且使代码更加容易维护。下面这段代码是一段Android事件监听代码：
 *
 * 一般使用匿名内部类的方法来编写事件监听代码,大部分匿名内部类用于接口回调。
 * 同样的，匿名内部类也是不能有访问修饰符和static修饰符的。
 */
public class Test3 {


    /**
     * 匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。
     * 一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。
     */


    //注意：局部内部类和匿名内部类只能访问局部final变量
    //匿名内部类
    public void method(final int b) {
        final int a = 10;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }

    public static void main(String[] args) {
        Test3 test3=new Test3();
        test3.method(6);
    }

}
