package com.datastructure.learning.basicTest.customEarithmetic.halfSearch;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 *
二分查找法是对一组有序的数字中进行查找，传递相应的数据，进行比较查找到与原数据相同的数据，
返回的结果：查找到了返回1，失败返回对应的数组下标。
二分查找算法就是不断将数组进行对半分割，每次拿中间元素和goal元素进行比较。
折半查找的先决条件是查找表中的数据元素必须有序(缺点)
折半查找方法适用于不经常变动而查找频繁的有序列表。

二分算法步骤描述
① 首先确定整个查找区间的中间位置 mid = （ left + right ）/ 2
② 用待查关键字值与中间位置的关键字值进行比较；
若相等，则查找成功
若大于，则在后（右）半个区域继续进行折半查找
若小于，则在前（左）半个区域继续进行折半查找
③ 对确定的缩小区域再按折半公式，重复上述步骤。
 *
 * 二分查找法：
 * //方式一：二分查找普通循环实现
 */
public class HalfSearch1 {

    public static void main(String[] args) {

    }
    // 参数:整型数组,需要比较的数
    public static int halfSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        // int mid = arr.length / 2;
        if (key == arr[mid]) {   //相等，则查找成功
            return mid;
        }
        while (start <= end) {       //while循环，大的条件
            mid = (start + end) / 2;
            if (key < arr[mid]) {   //小于，则在前（左）半个区域继续进行折半查找
                end = mid - 1;
            } else if (key > arr[mid]) {    //大于，则在后（右）半个区域继续进行折半查找
                start = mid + 1;
            } else {        //直到key=arr[mid]
                return mid;
            }
        }
        return -1;   //不存在要找的值key，返回-1
    }
}
