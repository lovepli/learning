package com.datastructure.learning.basicTest.设计模式.过滤器模式;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description: 过滤器：自定义方法对请求进行判断拦截数据加工等操作
 */
public interface Filter {  //过滤器接口

    /**
     *对请求进行一次过滤或者处理
     * 如果继续执行后面的过滤器，返回true，否则返回false
     * @param request    请求类
     */
    public boolean execute(Request request);

}
