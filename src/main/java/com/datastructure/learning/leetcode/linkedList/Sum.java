package com.datastructure.learning.leetcode.linkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 递归 数组求和
 */
public class Sum {
    //给用户调用
    public static int sum(int [] arr) {
        return sum(arr,0);
    }

    //内部私有方法 计算arr[l...n)这个区间内所有数字的和 n为开区间
    private static int sum(int [] arr,int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] +sum(arr,l+1);
    }

    public static void main(String[] args) {
        int [] nums={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sum(nums));
    }
}
