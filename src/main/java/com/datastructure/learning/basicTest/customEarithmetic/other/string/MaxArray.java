package com.datastructure.learning.basicTest.customEarithmetic.other.string;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 * //求一个长度为10的整形数组中的最大元素，采用随机赋值的方式并输出各元素的值
 */
public class MaxArray {
    public static void main(String[] args) {
        int[] a=new int [10];
        for(int i=0;i<a.length;i++){
            a[i]=new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(a));

        int max=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        System.out.println(max);
    }
}
