package com.datastructure.learning.basicTest.基础知识.接口;

import java.lang.reflect.Method;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:
 */
/**
 * JavaSE 8新特性：1.接口可以定义非抽象方法  但必须使用default或者staic关键字来修饰
 */
interface Chinese {

    //小结：2.JDK1.8规定只能在接口定义defult方法  且必须加Body实现
    default String speak() {
        return "会说普通话!";
    }
    //小结：3.接口的默认实现方法支持重载
    default String speak(String language) {
        return "会说"+language;
    }

    //小结：4.接口可以定义static方法
    static void hehe() {
        System.out.println("我不告诉你");
    }



}
//小结：4.接口的default方法可以被子接口重写成default方法
interface GuangDong extends Chinese{
    @Override
    public default String speak() {
        return "粤语";
    }
}

//小结：5.接口的默认方法还可以被子接口重写成抽象方法！！
interface Mayun extends Chinese{
    @Override
    public String speak();
}

public class InterFaceDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        //小结：6.如果实现类没有重写接口的默认方法，则该类直接调用接口的默认实现方法
        System.out.println(new Chinese(){}.speak());
        System.out.println(new Chinese(){}.speak("粤语"));
//小结：7.接口的default方法可以被子类重写成普通方法
        System.out.println(new Chinese(){public String speak() {return "会说鸟语";}}.speak());

//小结：JDK1.8甚至允许直接调用接口的静态方法
        Chinese.hehe();

//小结：JDK1.8 可以通过反射来 判断接口的某个方法是否为default方法
        Method m =Chinese.class.getMethod("speak");
        System.out.println("It is "+m.isDefault()+" that "+m.getName()+" is default method");

    }
}


