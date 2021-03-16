package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;


/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class Solution189 {

    /**
     * 双重循环
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     *
     *  * 输入: nums = [1,2,3,4,5,6,7], k = 3
     *  * 输出: [5,6,7,1,2,3,4]
     */
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        //k %= n; // a-=b相当于a=a-b,a/=b相当于a=a/b,a%=b相当于a=a%b,a%b是求a除以b的余数
        k = k % n; // 求k除以n的余数,余数为0相当于没有进行旋转
        for (int i = 0; i < k; i++) { // 外层循环控制循环的次数 k=3次
            int temp = nums[n - 1]; // 最后一个元素 第一次循环的时候是7 第二次循环temp值为6
            for (int j = n - 1; j > 0; j--) { // 从数组最后一个元素进行倒序遍历
                nums[j] = nums[j - 1]; // 将前一个元素赋值给后一个元素
            }
            nums[0] = temp; // 将数组最后一个元素赋值给第一个元素
        }
    }

    /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     *  * 输入: nums = [1,2,3,4], k = 2
     *  * 输出: [3,4,1,2]
     *  * 第1次翻转: [4,3,2,1]
     *  * 第2次翻转: [3,4,2,1]
     *  * 第3次翻转: [3,4,1,2]
     *
     */
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1); // 第一次翻转 首尾下标位置开始（所有元素）
        reverse(nums, 0, k - 1); // 第二次翻转 首和翻转次数下标位置开始（下标k之前部分数组元素进行翻转）
        reverse(nums, k, n - 1); // 第三次翻转，翻转次数下标位置和尾位置开始（下标k之后部分数组元素进行翻转）
    }

    /**
     * 数组元素翻转，首尾向内依次对称翻转
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    /**
     * 递归交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(n/k)
     */
    public void rotate(int[] nums, int k) {
        // 原理同上
        recursiveSwap(nums, k, 0, nums.length);
    }

    private void recursiveSwap(int[] nums, int k, int start, int length) {
        k %= length;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            recursiveSwap(nums, k, start + k, length - k);
        }
    }

    /**
     * 数组元素互相交换位置
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5,6,7};
       int k = 3;
       new Solution189().rotate_1(nums,k);
    }
}
