package com.datastructure.learning.basicTest.设计模式.代理模式;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description: 婚庆公司
 */
public class WeddingCompany implements ProxyInterface {

    //私有 引入的接口对象 ？？？
    private ProxyInterface proxyInterface;

    //构造函数
    public WeddingCompany(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public void marry() {
        System.out.println("我们是婚庆公司的");
        System.out.println("我们在做结婚前的准备工作");
        System.out.println("节目彩排...");
        System.out.println("礼物购买...");
        System.out.println("工作人员分工...");
        System.out.println("你们可以开始结婚了");
        //接口的实现类NormalHome实现结婚的方法
        proxyInterface.marry();
        System.out.println("结婚完毕，我们需要做后续处理，你们可以回家了，其余的事情我们公司来做");
    }

}