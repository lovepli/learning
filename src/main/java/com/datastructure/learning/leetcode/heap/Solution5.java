package com.datastructure.learning.leetcode.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import java.util.PriorityQueue; //优先队列
import  java.util.Comparator;  //比较器

/**
 * @author: lipan
 * @date: 2019-05-30
 * @description:  这里我们使用Java标准库中的优先队列java.util.PriorityQueue
 * Java标准库中的优先队列PriorityQueue 使用的是最小堆 需要改的地方还不少！
 *
 * 在Solution4基础上改进！！！
 */
public class Solution5 {

    private class Freq{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        //改变两个整形Integer之间的比较
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//
//        });

        //进一步改进 替换匿名类，Java8 的新特性！！
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)

        );


        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(key);
            else if(map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove());
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    //测试
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }

}



