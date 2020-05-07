package com.datastructure.learning.basicTest.常见的排序算法.recursive;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 *
 * 递归算法：
 *
 * 1.观察下面的数列，请找出他的通项公式，并用程序产生前50项，按从下到大的顺序显示，每列显示五项，每项间用TAB分割开来
 * 0、1、1、2、3、5、8、13
 */
public class DiGui {

    public static  int f(int n){
        if(n==1){
            return 0;
        }else if(n==2 || n==3){
            return 1;
        }else{
            return f(n-1)+f(n-2);
        }
    }
    public static void main(String[] args) {
        for(int n=1;n<=50;n++){
            System.out.print(f(n)+" "+"TAB"+" ");
            if(n%5==0){
                System.out.println();
            }
        }
    }

}
