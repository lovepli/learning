package com.datastructure.learning.basicTest.customEarithmetic.other.string;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 */
public class MaxArray1 {

    int[] arr=new int [10];

    //获取最大值的方法
    public static int getMaxValue(int [] a){
        int max=a[0]; // 假设第一个数最大
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }

    //给数组赋值的方法
    public static void setValue(int[] a){
        for(int i=0;i<a.length;i++){
            a[i]=(int) (Math.random()*100);
        }
    }

    //显示数组元素的方法
    public static void showArray(int[] a){
        System.out.println("数组中元素值为:");
        for(int i=0;i<a.length;i++){
            System.out.print(" "  +a[i]);

            if((i+1)%5==0){      //每五个元素换一行
                System.out.println();
            }
        }
    }

    //（补充）对数组进行排序(冒泡排序)
    public static void bubbleSort(int [] a){

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
