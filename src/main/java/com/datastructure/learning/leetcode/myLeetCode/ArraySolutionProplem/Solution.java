package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description:
 * 数组面试高频考题:
 * 删除排序数组中的重复项 【26】
 * 移除元素 【27】
 * 移动零 【283】
 * 数组中重复的数字 【剑指offer03】
 * 旋转数组 【189】
 * 螺旋矩阵 【54】
 * 两数之和 【1】
 * 三数之和 【15】
 * 四数之和 【18】
 * 较小的三数之和 【259】
 * 最接近的三数之和 【16】
 * 合并两个有序数组 【88】
 * 寻找旋转排序数组中的最小值 【153】
 * 寻找旋转排序数组中的最小值 II 【154】
 * 除自身以外数组的乘积 【238】
 */
public class Solution {

    /**
     * 思路：双指针往后移动，如果后面一个与前面一个元素相等，则将后面的所有元素向前移动一位，不相等则跳过这个元素继续向后移动位置
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while (nums[i]==nums[j]){
   for (int k=nums.length-1-j;k>1;k--){
      // int temp=nums[k-1];
        nums[k-1]=nums[k];
   }


        }

     return 0;
    }



    public static void main(String[] args) {
        //输入：nums = [1,1,2]
        //输出：2, nums = [1,2]
        int [] nums={0,0,1,1,1,2,2,3,3,4}; //5, nums = [0,1,2,3,4]
        //0,0,0,0,1,1,1,1,2,2
        //0,0,0,1,1,1,1,2,2,2
        //0,0,1,1,1,1,2,2,2,2
        //0,1,1,1,1,2,2,2,2,2
        //0,1,1,1,2,2,2,2,2,2
        //0,1,1,2,2,2,2,2,2,2
        //0,1,2,2,2,2,2,2,2,2

        //0,1,2,2,3,3,4
        System.out.println("输出："+new Solution().removeDuplicates(nums));
    }
}
