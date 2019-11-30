package com.datastructure.learning.datastucture.Heap;

import java.util.Random;

/**
 * @author: lipan
 * @date: 2019-05-30
 * @description:
 * heapitfy:将任意数组整理成堆的形状 ，理解图列的设计思想！！
 */
public class MaxHeapTest {

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 向堆中添加元素并且取出堆中的最大元素 add() 和 extractMax() 的时间复杂度都是 O(log(n))
     */
    private static  void maxHeapTest() {
        int n=1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }

    public static void main(String[] args) {

       // maxHeapTest();

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        //将n个元素逐一插入到一个空的堆中，时间复杂度为：O(nlog(n))
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        //使用heapify的过程，时间复杂度为O(n)
        double time2 = testHeap(testData, true); //性能有了提升
        System.out.println("With heapify: " + time2 + " s");




    }
}
