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
 * 在Solution3基础上改进！！！
 */
public class Solution4 {

    private class Freq{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

    }

   /* //自己设置Freq类的比较器，自定义灵活

    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq a,Freq b) {
            return a.freq - b.freq;
        }
    }
*/

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        //改成匿名函数实现转换
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){

            @Override
            public int compare(Freq a, Freq b) {
                return a.freq - b.freq;
            }

        });
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
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


