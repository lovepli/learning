package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 反转字符串中的元音字母
 * 题目描述
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class Solution345 {
    /**
     * 解法
     * 将字符串转为字符数组（或列表），定义双指针 p、q，分别指向数组（列表）头部和尾部，当 p、q 指向的字符均为元音字母时，进行交换。
     *
     * 依次遍历，当 p >= q 时，遍历结束。将字符数组（列表）转为字符串返回即可。
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        int p = 0, q = chars.length - 1;
        while (p < q) {
            if (!isVowel(chars[p])) {
                ++p;
                continue;
            }
            if (!isVowel(chars[q])) {
                --q;
                continue;
            }
            swap(chars, p++, q--);
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    private boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
