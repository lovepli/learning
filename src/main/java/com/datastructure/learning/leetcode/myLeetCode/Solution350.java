package com.datastructure.learning.leetcode.myLeetCode;


import cn.hutool.json.JSONArray;

import java.util.*;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 两个数组的交集 II
 *给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 标签：排序 哈希表 双指针 二分查找
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> hashSet=new HashSet<Integer>();
        Set<Integer> hashSet2=new HashSet<Integer>();
        for(Integer n1:nums1){
            hashSet.add(n1);
        }
        for (Integer n2:nums2){
            hashSet2.add(n2);
        }
        List<Integer> list=new ArrayList<Integer>();
        if(hashSet.size()-hashSet2.size()>=0){
            for(Integer set2:hashSet2){
                if(hashSet.contains(set2)){
                    list.add(set2);
                }
            }
            int[] array0 = new int[list.size()];
            for (int i=0;i<array0.length;i++){
                array0[i]=list.get(i);
            }
            return array0;
        } else {
            for(Integer set1:hashSet){
                if(hashSet2.contains(set1)){
                    list.add(set1);
                }
            }
            int[] array0 = new int[list.size()];
            for (int i=0;i<array0.length;i++){
                array0[i]=list.get(i);
            }
            return array0;
        }
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] array=  findJaoJi(nums1,nums2);
        Map<Integer,Integer> map =fun1(nums1,nums2);
        int[] arr=find4(array,map);
        return arr;

    }


    /**
     * 获得重复元素重复的次数
     * @param num
     * @param data
     * @return
     */
    private int findChongFu(int [] num,int data){
        int n=0;
         for(int i=0;i<num.length;i++){
             if(num[i] == data){
                 n++;
             }
         }
         return  n;
    }

    /**
     * 获得数组中重复过的元素组成的数组
     * @param
     */
    private  int [] findChongFu2(int [] num){
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])){
                System.out.println("重复的元素"+num[i]);
                set.add(num[i]);
            }
            map.put(num[i],i);
        }
        int[] array = new int[set.size()];
        int index=0;
        for(Integer se:set){
          array[index++]=se;
        }
        return array;
    }

    /**
     * 获得重复的元素以及重复的元素对应的次数
     * @param num0 为原始数据
     * @param num 数组中重复过的元素组成的数组
     */
    private Map<Integer, Integer>  find3(int [] num0, int [] num){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length;i++){
            map.put(num[i], findChongFu(num0,num[i]));// 数组，重复元素
        }
        return map;
    }

    /**
     *  获得重复值的交集以及交集最少次数
     */
    private Map<Integer, Integer>  fun1(int[] nums1, int[] nums2){
     int [] num11= findChongFu2(nums1); //获得数组1中重复过的元素
     int [] num22= findChongFu2(nums2); //获得数组2中重复过的元素
        Map<Integer,Integer> map11=find3(nums1,num11);//获得重复的元素num11以及重复的元素分别对应的次数
        Map<Integer,Integer> map22=find3(nums2,num22);//获得重复的元素num22以及重复的元素分别对应的次数

        Map<Integer,Integer> map33=new HashMap<>();
        if(map11.size()-map22.size()>=0){
            // 遍历key
            Set<Integer> keySet = map22.keySet();
            for(Integer key : keySet) {
                System.out.println("key:"+key);
                if(map11.containsValue(key)){
                 if(map11.get(key)-key <=0){
                     map33.put(key,map11.get(key));
                 }
                }
            }
        }else {
            // 遍历key
            Set<Integer> keySet = map11.keySet();
            for(Integer key : keySet) {
                System.out.println("key:"+key);
                if(map22.containsValue(key)){
                    if(map22.get(key)-key <=0){
                        map33.put(key,map22.get(key));
                    }
                }
            }
        }
        return map33;
    }

    /**
     *获得num11和num22重复的元素的交集
     * @param nums1
     * @param nums2
     * @return
     */
    //private int []  fun2(int[] nums1, int[] nums2){
    //    int [] num11= findChongFu2(nums1); //获得数组1中重复过的元素
    //    int [] num22= findChongFu2(nums2); //获得数组2中重复过的元素
    //    // 获得num11和num22重复的元素的交集
    //    int [] array=findJaoJi(num11,num22);
    //    return  array;
    //}

    /**
     * 获得两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] findJaoJi(int[] nums1, int[] nums2) {
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        Set<Integer> set3= new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            set2.add(nums2[j]);
        }

        if(set1.size() - set2.size()>=0){
          for(Integer see:set2){
             if(set1.contains(see)){
                 set3.add(see);
             }
          }
        }else {
            for(Integer see:set1){
                if(set2.contains(see)){
                    set3.add(see);
                }
            }
        }
        // set转为数组
        int [] ints=new int[set3.size()];
        int index=0;
        for(Integer se3:set3){
            ints[index++]=se3;
        }
        return ints;
    }

    /**
     *
     * @param num 交集
     *  @param map33 交集中元素和元素的次数
     */
    private int [] find4( int [] num,Map<Integer,Integer> map33){
       // 给交集中的元素按照次数添加多个
        List<Integer> list=new ArrayList();
        for(int i=0;i<num.length;i++){
            if(map33.containsKey(num[i])){
              //  map33.get(num[i]); // 重复的次数
                for(int j=0;j<map33.get(num[i]);j++){
                    list.add(num[i]);
                }
            }
            list.add(num[i]);
        }
        // 集合转数组
        int [] ints = new int[list.size()];
        int index=0;
        for(Integer ll:list){
            ints[index++]=ll;
        }
        return ints;
    }



    public static void main(String[] args) {
       int[] nums1 = {1,2,2,1};
       int [] nums2 = {2,2}; // 目标 [2,2]
       int [] array= new Solution350().intersect(nums1,nums2);
        JSONArray jsonArray=new JSONArray(array);
        System.out.println("得到的数组："+jsonArray.toString());
    }

    /**
     * 扩展知识点：
     *  * 遍历Map的三种方式
     *  * 1:遍历所有的key
     *  * 2:遍历所有的键值树(key-value)
     *  * 3:遍历所有的value(不常用)
     */
    public void  MapDemo(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        //     ( k   , v )
        map.put("语文", 90);
        map.put("数学", 98);
        map.put("物理", 85);
        map.put("化学", 78);
        map.put("英语", 92);
        map.put("体育", 65);
        map.put("体育", 78);

        /*
         * 遍历所有的key
         * Set<K> keySet()
         * 该方法可以获取Map中所有的key，并将它们存入
         * 一个Set集合中返回
         * 所以，遍历该集合就等于遍历所有的key了
         */
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            System.out.println("key:"+key);
        }
        /*
         * 遍历键值树
         * Set<Entry> entrySet()
         * 该方法会将每一组key-value存入一个Entry
         * 实例中，并将这些Entry实例存入一个Set集合
         * 并返回
         * 我们只需要便利该集合，拿到每一个Entry实例
         * 并获取其中的key与value即可
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> e:entrySet) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
         * 遍历所有的value
         */

        Collection<Integer> values = map.values();
        for(Integer value : values) {
            System.out.println("value:"+value);
        }

    }

}

/**
 *
 */
