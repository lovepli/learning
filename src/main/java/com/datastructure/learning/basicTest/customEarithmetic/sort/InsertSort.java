package com.datastructure.learning.basicTest.customEarithmetic.sort;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 * 插入排序
 * //排序思路：每次将一个待排序的元素与已排序的元素进行逐一比较，直到找到合适的位置按大小插入。
 */
public class InsertSort {

    public static void insertsort(int arr[]){
        for(int i = 1;i < arr.length; i ++){
            if(arr[i] < arr[i-1]){//注意[0,i-1]都是有序的。如果待插入元素比arr[i-1]还大则无需再与[i-1]前面的元素进行比较了，反之则进入if语句
                int temp = arr[i];
                int j;
                for(j = i-1; j >= 0 && arr[j] > temp; j --){
                    arr[j+1] = arr[j];//把比temp大或相等的元素全部往后移动一个位置
                }
                arr[j+1] = temp;//把待排序的元素temp插入腾出位置的(j+1)
            }
        }
    }

    public static void main(String[] args) {

    }


}
