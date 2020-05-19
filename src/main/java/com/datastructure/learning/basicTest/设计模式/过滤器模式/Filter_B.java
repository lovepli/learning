package com.datastructure.learning.basicTest.设计模式.过滤器模式;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description:
 */
public class Filter_B implements Filter{
    @Override
    public boolean execute( Request request) {
        System.out.println("请求"+request.getName()+"正在执行Filter_B过滤器-----------------------");
        //对请求进行判断
        if (request!=null&&request.getNum()>20){
            System.out.println(request.getInfo()+"通过了Filter_B过滤器,继续执行下一个");
            request.setInfo(request.getInfo()+"通过了Filter_B过滤器 ");
            return true;
        }else if (request!=null){
            request.setInfo(request.getInfo()+"未通过了Filter_B过滤器,停止执行\n");
        }
        return false;
    }

}
