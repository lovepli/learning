package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution434 {

    public int countSegments(String s) {
        String [] str=s.split(" ");
        int num=0;
        for (String s1:str){
            if(!s1.isEmpty() && s1  !=""){
                num++;
            }
        }
        return num;
    }

    public int countSegments_2(String s) {
        String[] arr = s.split(" ");
        int len = 0;
        for (String t : arr) {
            if (t.equals(" ") || t.isEmpty()){
                continue;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s="Hello, my name is John";
        System.out.println("单词数："+new Solution434().countSegments(s));
    }

}
