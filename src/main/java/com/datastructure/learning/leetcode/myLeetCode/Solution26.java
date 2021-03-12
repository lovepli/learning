package com.datastructure.learning.leetcode.myLeetCode;

import cn.hutool.json.JSONArray;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝。 既：如果重新赋值则不再是源对象。所以不能使用例如Arrays.sort此类的方法改动数组nums
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution26 {

    /**
     * Java 双指针解法 提交用时 2ms 超越 92.94%
     * @param nums nums = [0,0,1,1,1,2,2,3,3,4]
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 排除一下特殊情况，size为0或者size为1
        if(nums==null || nums.length == 1){
            return nums.length;
        }

        // 使用双指针
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                //System.out.println(nums[i]+"==="+nums[j]);
                nums[i]=nums[j];
                j++;
            }
        }
        //JSONArray jsonArray=new JSONArray(nums);
        //System.out.println("结果数组："+jsonArray.toString());
        return i+1;
    }

    /**
     * 方法一的变形
     * 思路：
     * n为不重复数组的最后一位的下标。
     * 遍历可从下标为1开始，由于该数组为排序数组，则只要nums[i]不等于nums[n],n向后移，并且赋值当前nums[i]
     * 举例nums：1 , 1 , 2 , 3
     *
     * 当 n = 0, i = 1时， 1 = 1 则跳过；
     * 当 n = 0, i = 2时， 1 != 2 则，n = 1; nums[1] = 2, 则原数组为：
     * 1 , 2 , 2 , 3
     *
     * n = 1, i = 3时， 2 != 3 则，n = 2; nums[2] = 3, 则原数组为：
     * 1 , 2 , 3 , 3
     *
     * 遍历结束， 由于n 为下标，则长度还应该+1;
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }

        int n = 0; // 指针
        for (int i = 1; i < nums.length; i++) { //j指针移动
            if (nums[n] != nums[i]) {
                //n++; // n指针移动
                //nums[n] = nums[i]; // 优化省略一行代码
                nums[++n] = nums[i];
            }
        }
        return n + 1;
    }

    /**
     * 常规操作，先去除异常场景。把数组是null和数组为空的情况排除。
     * 由于题目要求只能在原数组上删除，且该数组是个排好序的数组。那么我们可以定义一个游标 index，来记录需要替换为后面数据的位置。
     * 由于第一个元素肯定是要保留在数组中的，因此起始，我们将游标指向数组的第二个元素（此位置为可能替换元素的位置），数组下标指向第二个元素。
     * 判断游标指向位置的前一个元素的值和当前获取的数组下标值是否相同。若相同，则游标位置不变，数组下标后移。若不同，代表需要把新元素替换到游标指向的位置。
     * 则替换元素，并且游标指向下一个位置，计数项加一。
     * 按此操作循环整个数组可得到最终结果。
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1; // 计数器
        int index = 1; // 游标
        for (int i = 1; i < nums.length; i++) { // i 数组下标
            if (nums[i] == nums[index - 1]) {
                continue; // 跳出当前循环，继续进行下一个循环
            }
            nums[index] = nums[i];
            index++;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums0 = {0,1,2,3,3,4};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = new Solution26().removeDuplicates3(nums0);
        System.out.println(i);
    }

}
