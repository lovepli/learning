package com.datastructure.learning.basicTest.设计模式.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description: 过滤器容器：存储多个过滤器，可以自定义执行顺序和数量，并使请求执行过滤器列表
 */
public class FilterContainer {
    private List<Filter> list=new ArrayList<>();
    //设置要执行的过滤器列表
    public void setFilterList(List<Filter> list){
        this.list=list;
    }
    //执行过滤器
    public void doFilter(Request request){
        for (Filter filter:list) {
            //如果返回false,结束执行
            if (!filter.execute( request)){
                break;
            }
        }
        System.out.println("执行完成！");
    }
}
