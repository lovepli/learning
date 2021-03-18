package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution125 {

    /**
     * 思路：去除所有字符和空格，行程一个新的字符串，然后对新的字符串进行首位对称比较
     * 分享个字母大小写转换的方法：
     *
     * 统一转成大写：ch & 0b11011111 简写：ch & 0xDF
     * 统一转成小写：ch | 0b00100000 简写：ch | 0x20
     * 比较的时候注意加上小括号哦，因为位运算优先级比较低。
     *
     * 使用示例：
     * if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) return false;
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
   return false;
    }

    public boolean isPalindrome_1(String s) {
        if (s == null) return true;
        s = s.toLowerCase(); // 字符串全部转为小写
        System.out.println("转换为小写字符串："+s);
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                System.out.println("字符"+c);
                str.append(c);
            }
        }
        System.out.println("翻转的字符串："+str.reverse().toString());
        return str.toString().equals(str.reverse().toString()); // 字符串与翻转之后的字符串进行比较，reverse()这种方法可以代替自己手写翻转方法
    }

    public static void main(String[] args) {
        String str= "A man, a plan, a canal: Panama";
        System.out.println("是否是回文字符串："+new Solution125().isPalindrome_1(str));
    }
}
