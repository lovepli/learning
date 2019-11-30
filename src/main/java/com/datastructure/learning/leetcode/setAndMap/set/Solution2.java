package com.datastructure.learning.leetcode.setAndMap.set;

import java.util.ArrayList;
import java.util.TreeSet;  //引入TreeSet

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 第349题 使用Set集合
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums1) //遍历数组添加到集合中 数组--> 集合
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();  //集合TreeSet 和 集合Arraylist的区别？？
        for(int num: nums2){
            if(set.contains(num)){  //比较
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];  //新建一个长度等于集合元素长度的空数组  集合--> 数组
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;
    }
}
