package com.datastructure.learning.basicTest.拦截器;

/**
 * @author: lipan
 * @date: 2020-05-08
 * @description: 三、拦截器：普通的JavaBean，在调用业务方法的之前或者之后会自动拦截并执行自己的一些方法。
 */
public class InterceptorClass {
    public void before(){
        System.out.println("拦截器InterceptorClass方法调用:before()!");
    }
    public void after(){
        System.out.println("拦截器InterceptorClass方法调用:after()!");
    }
}
