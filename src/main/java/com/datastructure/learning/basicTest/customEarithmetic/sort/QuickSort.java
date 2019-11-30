package com.datastructure.learning.basicTest.customEarithmetic.sort;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *   快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 34, 35, 18, 92, 46, 28, 55, 73, 64 };
        quick(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static void quick(int arr[], int start, int end) {
        int i = start;
        int j = end;
        int temp = arr[start];
        while (i < j) {
// 从后往前比较
            for (; j > i; j--) {
                if (arr[j] < temp) {
                    arr[i] = arr[j];
                    i++;
                    break;
                }
            }
            for (; i < j; i++) {
                if (arr[i] > temp) {
                    arr[j] = arr[i];
                    j--;
                    break;
                }
            }
            arr[i] = temp;
            if (i > start + 1) {
                quick(arr, start, i - 1);
            }
            if (j < end - 1) {
                quick(arr, j + 1, end);
            }
        }
    }
}
