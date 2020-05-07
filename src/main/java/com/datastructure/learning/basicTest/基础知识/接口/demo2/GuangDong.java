package com.datastructure.learning.basicTest.基础知识.接口.demo2;

/**
 * @author: lipan
 * @date: 2020-04-22
 * @description:
 */
interface GuangDongextends extends  Chinese {

    //实现非抽象方法
    @Override
    public default String speak() {
        return "粤语";
    }
}
