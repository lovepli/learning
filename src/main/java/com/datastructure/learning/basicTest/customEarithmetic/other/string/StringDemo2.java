package com.datastructure.learning.basicTest.customEarithmetic.other.string;

import java.util.Scanner;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 * 编写统计给定字符串不同类别字符个数的方法，分类包括：英文字母，空白字符（空格，tab，回车，换行），数字字符，方法无返回值，统计结果输出在屏幕上。
 */
public class StringDemo2 {
    public static void main (String args [ ] ){
        Scanner s = new Scanner(System.in);//实例化输入流
        String st = null ; //定义字符串用于接收输入
        System.out.println("请输入字符串：");
        st =s.next();  //完成对输入的接收
        char[] c= st.toCharArray(); //将接收的字符串转化为字符数组
        int n=0; //用于数字字符计数
        for (int i = 0; i < c.length; i++) {
            if(c[i]>='0'&&c[i]<='9'){
                n++;
            }
        }
        int n1=0; //用于小写字母字符计数
        for (int i = 0; i < c.length; i++) {
            if(c[i]>='a'&&c[i]<='z'){
                n1++;
            }
        }
        int n2=0; //用于大写字母字符计数
        for (int i = 0; i < c.length; i++) {
            if(c[i]>='A'&&c[i]<='Z'){
                n2++;
            }
        }
        int n3=c.length-n-n1-n2; //排除已计数字符后的剩余字符数
        System.out.println("您输入的字符串中数字的个数是"+n);
        System.out.println("您输入的字符串中小写字母的个数是"+n1);
        System.out.println("您输入的字符串中大写字母的个数是"+n2);
        System.out.println("您输入的字符串中其它字符的个数是"+n3);
    }
}
