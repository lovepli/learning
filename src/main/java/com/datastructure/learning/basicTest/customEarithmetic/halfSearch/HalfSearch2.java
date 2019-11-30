package com.datastructure.learning.basicTest.customEarithmetic.halfSearch;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 * //方式二: 二分查找递归实现
 */
public class HalfSearch2 {
    public static void main(String[] args) {

    }

    public static int halfSearch2(int arr[], int start, int end, int key) {
        int mid = (end+start)/2;
        if ( key==arr[mid] ) {
            return mid;
        }
        if (start >= end) {    //数组不成立，返回-1
            return -1;
        }
        else if (key > arr[mid]) {
            return halfSearch2(arr, mid + 1, end, key);
        }
        else if (key < arr[mid]) {
            return halfSearch2(arr, start, mid - 1, key);
        }
        return -1;
    }
}

