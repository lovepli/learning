package com.datastructure.learning.basicTest.设计模式.代理模式;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Test {
    public static void main(String[] args) {

        //多态的体现
        ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
        proxyInterface.marry();
    }
}
