package com.datastructure.learning.leetcode.myLeetCode;

import cn.hutool.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 标签：数组，hash表
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    /**
     * 两数之和
     * 方法1:暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                     return new int[]{i,j};
                }
            }
        }
       return new int[0];
    }

    /**
     * 两数之和
     * 方法2：哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> integerMap= new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(integerMap.containsKey(target-nums[i])){
                return new int[]{integerMap.get(target-nums[i]),i};
            }
            integerMap.put(nums[i], i);
        }
       return new int[0];
    }

    public static void main(String[] args) {
        int [] nums={1,3,4,6,7};
        int target=8;
        // 数组转为json数组
        JSONArray jsonArray=new JSONArray(new Solution1().twoSum(nums,target));
       // JSONArray jsonArray=new JSONArray(new Solution1().twoSum2(nums,target));
        System.out.println("两数之和："+jsonArray.toString());
    }
    /**
     * 解析：思路及算法
     *
     * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。
     * 而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


}
