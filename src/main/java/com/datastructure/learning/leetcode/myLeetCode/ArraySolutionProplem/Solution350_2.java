package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
public class Solution350_2 {

    /**
     * 方法一
     * 先调用java的排序函数，再使用双指针解决，时间打败百分之百。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1<len2?len1:len2;
        int[] ans = new int[len];
        if(len1 == 0 || len2 == 0){  //处理边界条件
            return ans;
        }
        // 对组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, k=0;
        while(i<len1 && j<len2){
            if(nums1[i] == nums2[j]){
                ans[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }

    /**
     * 方法一
     * 排序+双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
        /*
            首先对两个数组进行排序，然后使用两个指针遍历两个数组。
            初始时，两个指针分别指向两个数组的头部。
            每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，
            如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。*/
            //第一个数组的第i个元素小于第二个数组的第j个元素
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        // list转化为数组
        int len = list.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }



    /**
     * 方法二
     * 使用map解决,具体操作如下
     * 遍历nums1中的所有元素，把它存放到map中，其中key就是nums1中的元素，value就是这个元素在数组nums1中出现的次数。
     * 遍历nums2中的所有元素，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后对应的value要减1。
     * 最后再把集合list转化为数组即可
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}

