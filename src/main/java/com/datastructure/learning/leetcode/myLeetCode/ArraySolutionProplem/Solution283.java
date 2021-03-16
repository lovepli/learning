package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution283 {
    /**
     * 题目一开始就理解出错了
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 假设数组中存在0,获取移动的步数k
        int k=0;
        for(int num:nums){
            if(num==0){
                k++;
            }
        }
        if(k>0){
            // 1、数组顺序排序 TODO 题目理解错了，只需要保持数组元素的相对顺序，不需要对数组元素进行排序
           Arrays.sort(nums);
          //  System.out.println("排序："+Arrays.toString(nums));
            //2、数组向左移动两位，题目就变成了数组旋转的问题
            // 解决方法(思路)：双重循环，翻转，循环交换，递归交换
            // 数组翻转   k=2   k=3
            // 0，0，1，3，12   //0，0，0，1，3，4，12
            // 12，3，1，0，0   //12，4，3，1，0，0，0
            // 1，3，12，0，0   //1，3，4，12，0，0，0
            reverse(nums,0,nums.length - 1);
            System.out.println("翻转第一次："+Arrays.toString(nums));
            reverse(nums,0,nums.length - 1-k);
            System.out.println("翻转第二次："+Arrays.toString(nums));
        }


    }

    /**
     * 数组元素翻转
     * @param nums
     * @param start
     * @param end
     */
    private void reverse( int [] nums,int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start++] =nums[end];
            nums[end--] = temp;
        }
    }


    public void moveZeroes_1(int[] nums) {
        //0，1，12，4，7，0，6，0，5               //1，3，0，12，4，7，0，6，0，5
        //1，12，4，7，6，5，0，0，0               //1，3，12，4，7，6，5，0，0，0

    }

     // 这种思路应该要能想的出来，自己手动画个图就能看出来
    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i]; // TODO 这一步想到了就好了。也包含将自己位置的元素赋值给自己
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0; // TODO 这一步想到了就好了。
        }
    }

    public void moveZeroes3(int[] nums) {
        //最优解法
        for(int i=0,count=0;i<nums.length;i++){
            if(nums[i] != 0){
                //执行替换操作
                if(count != i){
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums={1,3,2,4,0,5,0,6};
        new Solution283().moveZeroes(nums);
    }


}
