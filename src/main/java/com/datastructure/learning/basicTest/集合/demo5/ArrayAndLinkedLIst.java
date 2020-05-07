package com.datastructure.learning.basicTest.集合.demo5;

import java.util.*;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  时间复杂度比较  查询
 *
 */
public class ArrayAndLinkedLIst {

    public static final int N=50000; //50000 个数
    public static List values; //要查找的集合
    //放入 50000 个数给 value；
    static{
        Integer vals[]=new Integer[N];
        Random r=new Random();
        for(int i=0,currval=0;i<N;i++){
            vals[i]=new Integer(currval);
            currval+=r.nextInt(100)+1;
        }
        values= Arrays.asList(vals);
    }
    //通过二分查找法查找
    static long timeList(List lst){
        long start=System.currentTimeMillis();
        for(int i=0;i<N;i++){
            int index= Collections.binarySearch(lst, values.get(i));
            if(index!=i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis()-start;
    }
    public static void main(String args[]){
        System.out.println("ArrayList 消耗时间： "+timeList(new ArrayList(values)));
        System.out.println("LinkedList 消耗时间： "+timeList(new LinkedList(values)));
    }
}



