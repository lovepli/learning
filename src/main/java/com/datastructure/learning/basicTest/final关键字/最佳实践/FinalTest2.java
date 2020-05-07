package com.datastructure.learning.basicTest.final关键字.最佳实践;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:  使用final修饰变量会让变量的值不能被改变吗?
 */
public class FinalTest2 {
    public static void main(String[] args) {
        Color2.color[3] = "white";
        for (String color : Color2.color)
            System.out.print(color+" ");
    }
}


class Color2 {
    public static final String[] color = { "red", "blue", "yellow", "black" };
}

/**
 * 执行结果：
 * red blue yellow white
 * 看！，黑色变成了白色。 真的令人惊讶
 *
 * 解释：
 * 在使用findbugs插件时，就会提示public static String[] color = { "red", "blue", "yellow", "black" };这行代码不安全，但加上final修饰，这行代码仍然是不安全的，因为final没有做到保证变量的值不会被修改！​
 * ​ 原因是：final关键字只能保证变量本身不能被赋与新值，而不能保证变量的内部结构不被修改。例如在main方法有如下代码Color.color = new String[]{""};就会报错了
 */

