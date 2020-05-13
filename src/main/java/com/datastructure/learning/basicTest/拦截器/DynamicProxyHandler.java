package com.datastructure.learning.basicTest.拦截器;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @author: lipan
 * @date: 2020-05-08
 * @description: 二、代理处理器：包含了业务对象绑定动态代理类的处理，并实现了InvocationHandler接口的invoke方法。
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object business;    //被代理对象

    private InterceptorClass interceptor = new InterceptorClass();    //拦截器 普通的Java对象


    public Object bind(Object business) {
        this.business = business;
        return Proxy.newProxyInstance(
                //被代理类的ClassLoader
                business.getClass().getClassLoader(),
                //要被代理的接口,本方法返回对象会自动声称实现了这些接口
                business.getClass().getInterfaces(),
                //代理处理器对象
                this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        interceptor.before();
        result=method.invoke(business,args);
        interceptor.after();
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}