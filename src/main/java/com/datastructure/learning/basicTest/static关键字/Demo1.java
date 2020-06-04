package com.datastructure.learning.basicTest.static关键字;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description: 参考：https://www.cnblogs.com/dolphin0520/p/10651845.html
 */

class CarConstants {
    // 全局配置,一般全局配置会和final一起配合使用, 作为共享变量
    public static final int MAX_CAR_NUM = 10000;

}

class Car {
}


class CarFactory {
    // 计数器 全局计数
    private static int createCarNum = 0;

    public static Car createCar() {
        if (createCarNum > CarConstants.MAX_CAR_NUM) {
            throw new RuntimeException("超出最大可生产数量");
        }
        Car c = new Car();
        createCarNum++; //计算生成了多少量车
        return c;
    }

    public static int getCreateCarNum() {
        return createCarNum;
    }

}


public class Demo1 {

    /**
     * 一.static关键字使用场景
     * 　　static关键字主要有以下5个使用场景：
     *
     * 1）静态变量
     *
     * 　　把一个变量声明为静态变量通常基于以下三个目的：
     *
     * 1、作为共享变量使用
     *
     * 2、减少对象的创建
     *
     * 3、保留唯一副本
     *
     *第一种比较容易理解，由于static变量在内存中只会存在一个副本，所以其可以作为共享变量使用，比如要定义一个全局配置、进行全局计数。如：
     *
     * 2）静态方法
     *
     * 　　将一个方法声明为静态方法，通常是为了方便在不创建对象的情况下调用。这种使用方式非常地常见，比如jdk的Collections类中的一些方法、单例模式的getInstance方法、工厂模式的create/build方法、util工具类中的方法。
     *
     * 3）静态代码块
     *
     * 　　静态代码块通常来说是为了对静态变量进行一些初始化操作，比如单例模式、定义枚举类：
     *
     * 4）静态内部类
     *
     * 　　关于内部类的使用场景可参考之前写的这篇文章 https://www.cnblogs.com/dolphin0520/p/3811445.html
     *
     * 　　内部类一般情况下使用不是特别多，如果需要在外部类里面定义一个内部类，通常是基于外部类和内部类有很强关联的前提下才去这么使用。
     *
     * 　　在说静态内部类的使用场景之前，我们先来看一下静态内部类和非静态内部类的区别：
     *
     * 　　非静态内部类对象持有外部类对象的引用（编译器会隐式地将外部类对象的引用作为内部类的构造器参数）；而静态内部类对象不会持有外部类对象的引用
     *
     * 　　由于非静态内部类的实例创建需要有外部类对象的引用，所以非静态内部类对象的创建必须依托于外部类的实例；而静态内部类的实例创建只需依托外部类；
     *
     * 　　并且由于非静态内部类对象持有了外部类对象的引用，因此非静态内部类可以访问外部类的非静态成员；而静态内部类只能访问外部类的静态成员；
     *
     *
     * 　　两者的根本性区别其实也决定了用static去修饰内部类的真正意图：
     *
     * 1、内部类需要脱离外部类对象来创建实例
     *
     * 2、避免内部类使用过程中出现内存溢出
     *
     * 　　第一种是目前静态内部类使用比较多的场景，比如JDK集合中的Entry、builder设计模式。
     *
     * 　　HashMap Entry：
     *
     * 5）静态导入
     *
     * 静态导入其实就是import static，用来导入某个类或者某个包中的静态方法或者静态变量。如下面这段代码所示：
     *  import static java.lang.Math.PI;
     *
     *     public  class MathUtils {
     *
     *     public static double calCircleArea(double r) {
     *         // 可以直接用 Math类中的静态变量PI
     *         return PI * r * r;
     *     }
     *  }
     *这样在书写代码的时候确实能省一点代码，但是会影响代码可读性，所以一般情况下不建议这么使用。
     *
     */


    /**
     * 2.static变量和普通成员变量区别
     * 　　static变量和普通成员变量主要有以下4点区别：
     *
     * 区别1：所属不同。static变量属于类，不单属于任何对象；普通成员变量属于某个对象
     *
     * 区别2：存储区域不同。static变量位于方法区；普通成员变量位于堆区。
     *
     * 区别3：生命周期不同。static变量生命周期与类的生命周期相同；普通成员变量和其所属的对象的生命周期相同。
     *
     * 区别4：在对象序列化时（Serializable），static变量会被排除在外（因为static变量是属于类的，不属于对象）
     */

    /**
     * 3.类的构造器到底是不是static方法？
     * 　　关于类的构造器是否是static方法有很多争议，在《java编程思想》一书中提到“类的构造器虽然没有用static修饰，但是实际上是static方法”，个人认为这种说法有点欠妥，原因如下：
     *
     * 　　1）在类的构造器中，实际上有一个隐藏的参数this引用，this是跟对象绑定的，也就是说在调用构造器之前，这个对象已经创建完毕了才能出现this引用。而构造器的作用是干什么的呢？它负责在创建一个实例对象的时候对实例进行初始化操作，即jvm在堆上为实例对象分配了相应的存储空间后，需要调用构造器对实例对象的成员变量进行初始化赋值操作。
     *
     * 　　2）我们再来看static方法，由于static不依赖于任何对象就可以进行访问，也就是说和this是没有任何关联的。从这一层面去讲，类的构造器不是static方法
     */

}
