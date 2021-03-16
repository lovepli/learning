package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution344 {

    /**
     * 利用数组性质，进行数组翻转，也叫对称翻转
     * @param s
     */
    public void reverseString(char[] s) {
        // 定义两个指针，分别指向首位位置
        int start=0;
        int end=s.length-1;
        while(start<end){
            char temp=s[start]; // 存储第一个元素
            s[start++] =s[end]; //将最后一个元素赋值给第一个元素
            s[end--] = temp;//将第一个元素赋值给最后一个元素
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
         char [] chars ={'h','e','l','l','o'};
         new Solution344().reverseString(chars);
    }

}
