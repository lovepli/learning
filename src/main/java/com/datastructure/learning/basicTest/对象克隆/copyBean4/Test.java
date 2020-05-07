package com.datastructure.learning.basicTest.对象克隆.copyBean4;

/**
 * @author: lipan
 * @date: 2020-04-09
 * @description: 对象深拷贝
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Body body = new Body(new Head(new Face()));
        Body body1 = (Body) body.clone();
        System.out.println("body == body1 : " + (body == body1) );   //false
        System.out.println("body.head == body1.head : " + (body.head == body1.head));  //false
    }
}
