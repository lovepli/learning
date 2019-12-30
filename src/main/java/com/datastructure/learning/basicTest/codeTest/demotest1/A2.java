package com.datastructure.learning.basicTest.codeTest.demotest1;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: 构造代码块（游离代码块）的使用
 */
public class A2 {
    public static void main(String[] args) {
        A1 a = new A1();
    }

}

class A1{
    int i = 1;
    int initValue;//成员变量的初始化交给代码块来完成
    {
        //代码块的作用体现于此：在调用构造方法之前，用某段代码对成员变量进行初始化。
        //而不是在构造方法调用时再进行。一般用于将构造方法的相同部分提取出来。
        //
        for (int i = 0;i < 100;i ++) {
            initValue += i;
        }
    }
    {
        System.out.println(initValue);//4950
        System.out.println(i);//此时会打印1
        int i = 2;//代码块里的变量和成员变量不冲突，但会优先使用代码块的变量
        System.out.println(i);//此时打印2
        //System.out.println(j);//提示非法向后引用，因为此时j的的初始化还没开始。
        //
    }
    {
        System.out.println("代码块运行");
    }
    int j = 2;
    {
        System.out.println(j);//2
        System.out.println(i);//1 代码块中的变量运行后自动释放，不会影响代码块之外的代码
    }
    A1(){
        System.out.println("构造方法运行");
    }
}
