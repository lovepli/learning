package com.datastructure.learning.basicTest.常见的排序算法.sort;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 * 选择排序：
 * //排序思路：从数组所有的元素中选出最小的放到第一个位置，然后再从剩下的元素中选出最小的放到第二的位置
 */
public class SelectSort {
    public static void main(String[] args) {

    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
    }
}
