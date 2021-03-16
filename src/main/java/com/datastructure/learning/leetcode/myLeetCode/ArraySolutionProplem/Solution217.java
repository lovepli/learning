package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 相关标签: 数组 哈希表
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        // 排除特殊情况
        if(nums == null || nums.length <=1){
           return false;
        }
        // 哈希表解决 解题思路和第一题相同
        Map<Integer,Integer> hashMap= new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if (hashMap.containsKey(nums[i])){
                return true;
            }
            hashMap.put(nums[i],i); // key 为数组元素的值，value为数组索引index
        }
      return false;
    }

    /*********************** 其他思路  ***************************************/
    /**
     * 排序
     * 数组排序后，判断相邻元素是否相等。
     * @param nums
     * @return
     * 时间复杂度 : O(n \log n)O(nlogn)。即排序的时间复杂度。扫描的时间复杂度 O(n)O(n) 可忽略。
     * 空间复杂度 : O(1)O(1)。 没有用到额外空间。如果深究 Arrays.sort(nums) 使用了栈空间，那就是 O(\log n)O(logn)。
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums); // 数组排序,对整型数组和字符串/字符型数组都可以按照顺序排序
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用 set，思路和使用map思路一致
     * 遍历数组，数字放到 set 中。如果数字已经存在于 set 中，直接返回 true。如果成功遍历完数组，则表示没有重复元素，返回 false。
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     *炫技,首先得了stream的特性
     * 这题可以一行代码解决。
     * Java 可以用 stream 实现一行将 int[] 转成 Set<Integer> 。为了更简短一些，可以直接利用 stream 的 distinct 和 count 算子。
     * @param nums
     * @return
     */
    public boolean containsDuplicate4(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }



    public static void main(String[] args) {
       int [] nums={1,2,3,4};
       int [] nums0={1,3,3,4,3,2,4,2,1,1,3,7,7,5,6,6};
       System.out.println("数组是否存在重复值："+new Solution217().containsDuplicate2(nums0));
    }
}
