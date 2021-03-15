package com.datastructure.learning.leetcode.myLeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Solution136 {

    /**
     * 解题思路，消除掉所有重复的元素则得到唯一的不重复的元素
     * 使用hashSet解题
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums)  {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2 ){
            System.out.println("不符合题意");
          //  throw new Exception("不符合题意");
        }
        Set<Integer> hashSet=new HashSet<>();
        Set<Integer> hashSet2=new HashSet<>();
        for(Integer n:nums){
            if(hashSet.contains(n)){
                hashSet2.add(n);
            }
            hashSet.add(n);
        }
         for(Integer n2:hashSet2){
             if(hashSet.contains(n2)){
                 hashSet.remove(n2);
             }
         }

         if(hashSet.size() == 1){
             for(Integer n3:hashSet){
                 return  n3;
             }
         }
     return nums[0];
    }

    /**
     * 使用数组解题
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums)  {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length == 2 ){ // i>=3
            System.out.println("不符合题意");
            //  throw new Exception("不符合题意");
        }
        Arrays.sort(nums); // 数组排序
        System.out.println("排序之后得到的数组："+Arrays.toString(nums));
        int i=0,j=1; // 双指针
        while(i<=nums.length){
            if(j==nums.length){
                return nums[i];
            } else {
                if(nums[i] == nums[j] ){
                    i+=2;
                    j+=2;
                }else {
                    System.out.println("===="+nums[i]);
                    return nums[i];
                }
            }

        }
        return nums[0];
    }

    public static void main(String[] args)  {
        int [] nums={1,2,1,2,3,4,4,5,6,5,6,7,7};
        int [] nums0={4,1,2,1,2};
        System.out.println("唯一不重复的元素为："+new Solution136().singleNumber2(nums));

    }
}
