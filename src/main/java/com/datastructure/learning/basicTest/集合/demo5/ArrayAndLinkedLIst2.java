package com.datastructure.learning.basicTest.集合.demo5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  时间复杂度比较  增删
 */
public class ArrayAndLinkedLIst2 {
        static final int N=50000;
        static long timeList(List list){
            long start=System.currentTimeMillis();
            Object o = new Object();
            for(int i=0;i<N;i++)
                list.add(0, o);
            return System.currentTimeMillis()-start;
        }
        public static void main(String[] args) {
            System.out.println("ArrayList 耗时： "+timeList(new ArrayList()));
            System.out.println("LinkedList 耗时： "+timeList(new LinkedList()));
        }
    }


