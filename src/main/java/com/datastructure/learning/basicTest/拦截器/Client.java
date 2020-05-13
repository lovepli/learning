package com.datastructure.learning.basicTest.拦截器;

/**
 * @author: lipan
 * @date: 2020-05-08
 * @description:  四、模拟客户端：执行业务处理的入口
 */
public class Client {
    public static void main(String args[]) {
        //代理处理器
        DynamicProxyHandler handler = new DynamicProxyHandler();
        //分为业务接口 业务类
        BusinessInterface business = new BusinessClass();
        //
        BusinessInterface businessProxy = (BusinessInterface) handler.bind(business);

        businessProxy.doSomething();
    }

    /**
     * Java中使用动态代理实现拦截器
     * 以一个简单的模型的来说明拦截器的实现的一般方法。
     *
     * 模型分为以下模块：
     * 业务组件：是被代理和被拦截的对象。
     * 代理处理器：实现了InvocationHandler接口的一个对象
     * 代理对象：Proxy对象。
     * 拦截器：普通的JavaBean，在调用业务方法的之前或者之后会自动拦截并执行自己的一些方法。
     * 客户端：执行业务处理的入口。
     */
}
