package com.datastructure.learning.leetcode.setAndMap.map;

import java.util.ArrayList;
import java.util.TreeMap;  //引入TreeMap

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 第350题 使用Map映射  注意345题与349题目的使用方法的不同！！！！
 */
public class Solution1 {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);  //num代表数字，1代表数字出现的频次
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){ //如果map映射中存在这个数字
                res.add(num); //将相同的数字num存进list集合
                map.put(num, map.get(num) - 1); //理解这一句话，num的次数value减1了
                if(map.get(num) == 0)  //出现的次数为0则从map映射中移除这个数字
                    map.remove(num);
            }
        }

        int[] ret = new int[res.size()];//新建一个长度等于集合元素长度的空数组  集合--> 数组
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }
}
