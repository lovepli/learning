package com.datastructure.learning.basicTest.final关键字;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Test1 {

    /**
     * final变量
     * final变量有成员变量或者是本地变量(方法内的局部变量)，在类成员中final经常和static一起使用，作为类常量使用。
     * 其中类常量必须在声明时初始化，final成员常量可以在构造函数初始化。
     */
    //public static final int i; //报错，必须初始化 因为常量在常量池中就存在了，调用时不需要类的初始化，所以必须在声明时初始化
    public static final int i2 = 0;
    public static int j;
    public final int a;
    Test1(int a) {
        this.a = a;
        //i = 2;
        j = 3;
        System.out.println("调用构造函数");//该方法不会调用
    }

    //就如上所说的，对于类常量，JVM会缓存在常量池中，在读取该变量时不会加载这个类。
    public static void main(String[] args) {
        System.out.println(Test1.i2);

    }


}
