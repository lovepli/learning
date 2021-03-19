package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 排序数组
 * 给你一个整数数组nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution912 {

    /**
     * 方法一：使用API
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public int[] sortArray_1(int[] nums) {
        int max=0;

        return null;
    }


    public static void main(String[] args) {
        int [] ints={5,1,1,2,0,0};
        System.out.println("排序数组："+Arrays.toString(new Solution912().sortArray(ints)));
    }
}
