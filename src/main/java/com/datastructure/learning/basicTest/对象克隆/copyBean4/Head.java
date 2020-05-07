package com.datastructure.learning.basicTest.对象克隆.copyBean4;

/**
 * @author: lipan
 * @date: 2020-04-09
 * @description:
 */
public class  Head implements Cloneable{
    public Face face;
    public Head(Face face) {}
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    } }
