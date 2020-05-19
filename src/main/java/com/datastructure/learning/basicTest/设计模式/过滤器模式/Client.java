package com.datastructure.learning.basicTest.设计模式.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description: 客户端执行
 */
public class Client {
    public static void main(String[] args) {
        //配置过滤器执行列表
        List<Filter> list=new ArrayList<>();
        list.add(new Filter_A());
        list.add(new Filter_B());
        list.add(new Filter_C());
        //加载过滤器容器
        FilterContainer filterContainer=new FilterContainer();
        filterContainer.setFilterList(list);
        //请求
        Request request1=new Request("请求1",25);
        Request request2=new Request("请求2",35);
        filterContainer.doFilter(request1);
        System.out.println(request1.getInfo());
        filterContainer.doFilter(request2);
        System.out.println(request2.getInfo());

        /**
         * 执行结果如下：
         * 请求请求1正在执行Filter_A过滤器-----------------------
         * 通过了Filter_A过滤器,继续执行下一个
         * 请求请求1正在执行Filter_B过滤器-----------------------
         * 通过了Filter_A过滤器 通过了Filter_B过滤器,继续执行下一个
         * 请求请求1正在执行Filter_C过滤器-----------------------
         * 执行完成！
         * 通过了Filter_A过滤器 通过了Filter_B过滤器 未通过了Filter_C过滤器,停止执行
         *
         * 请求请求2正在执行Filter_A过滤器-----------------------
         * 通过了Filter_A过滤器,继续执行下一个
         * 请求请求2正在执行Filter_B过滤器-----------------------
         * 通过了Filter_A过滤器 通过了Filter_B过滤器,继续执行下一个
         * 请求请求2正在执行Filter_C过滤器-----------------------
         * 通过了Filter_A过滤器 通过了Filter_B过滤器 通过了Filter_C过滤器,继续执行下一个
         * 执行完成！
         * 通过了Filter_A过滤器 通过了Filter_B过滤器 通过了Filter_C过滤器
         */
    }


    /**
     * 过滤器模式是一种设计模式，使开发人员可以使用不同的条件过滤一组对象，并通过逻辑操作以解耦方式将其链接。 这种类型的设计模式属于结构模式，因为该模式组合多个标准以获得单个标准。
     *
     * 主要有三个角色：
     * 1、请求实体类
     * 2、过滤器
     * 3、过滤器容器
     */

}
