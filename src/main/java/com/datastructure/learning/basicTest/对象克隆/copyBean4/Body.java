package com.datastructure.learning.basicTest.对象克隆.copyBean4;

/**
 * @author: lipan
 * @date: 2020-04-09
 * @description:  对象深拷贝
 */public class Body implements Cloneable{
    public Head head;
    public Body() {}
    public Body(Head head) {this.head = head;}
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Body newBody = (Body) super.clone();
        newBody.head = (Head) head.clone();
        return newBody;
    }
}




