package com.datastructure.learning.basicTest.final关键字.最佳实践;

import java.util.AbstractList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 如何保证数组内部不被修改？
 * 那可能有的同学就会问了，加上final关键字不能保证数组不会被外部修改，那有什么方法能够保证呢？
 * 答案就是降低访问级别，把数组设为private。这样的话，就解决了数组在外部被修改的不安全性，但也产生了另一个问题，那就是这个数组要被外部使用的。
 *
 * 这样就OK了，既保证了代码安全，又能让数组中的元素被访问了
 */
public class FinalTest3 {

    public static void main(String[] args) {
        //Color3._color[3] = "white";  //报错，私有的不能访问
        for (String color : Color3.color)
            System.out.print(color + " ");
        Color3.color.set(3, "white");
    }
}

class Color3 {

    private static String[] _color = {"red", "blue", "yellow", "black"};
    //匿名内部类 这里是new 一个抽象函数，而不是一个接口
    public static List<String> color = new AbstractList<String>() {
        @Override
        public String get(int index) {
            return _color[index];
        }

        @Override
        public String set(int index, String value) {
//            也没有操作成功，不知道为什么？？
//            Color3._color[index] = value;
//            return "test";

            throw new RuntimeException("为了代码安全,不能修改数组");
        }

        @Override
        public int size() {
            return _color.length;
        }
    };


}