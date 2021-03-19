package com.datastructure.learning.leetcode.myLeetCode.TodoOffer;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
       // return s.replace(/\s/g, '%20'); // 正则表达式
    }

    /**
     * 方法一：字符数组
     * 由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符。
     *
     * 获得 s 的长度 length
     * 创建字符数组 array，其长度为 length * 3
     * 初始化 size 为 0，size 表示替换后的字符串的长度
     * 从左到右遍历字符串 s
     * 获得 s 的当前字符 c
     * 如果字符 c 是空格，则令 array[size] = '%'，array[size + 1] = '2'，array[size + 2] = '0'，并将 size 的值加 3
     * 如果字符 c 不是空格，则令 array[size] = c，并将 size 的值加 1
     * 遍历结束之后，size 的值等于替换后的字符串的长度，从 array 的前 size 个字符创建新字符串，并返回新字符串
     *
     * @param s
     */
    public String replaceSpace_1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size); //String s = new String(char数组, 起始下标, 长度);
        return newStr;
    }



    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println("替换之后的字符串："+new Solution5().replaceSpace(s));
    }
}
