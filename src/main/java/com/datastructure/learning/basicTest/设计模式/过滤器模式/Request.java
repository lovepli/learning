package com.datastructure.learning.basicTest.设计模式.过滤器模式;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description: 请求类，模拟一次请求
 *  * 有名字和信息两个属性，根据实际情况自定义
 */
public class Request {  //请求实体类
    private String name;
    private String info="";

    //一个条件数值，用来过滤条件判断
    private int num;

    public Request(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
