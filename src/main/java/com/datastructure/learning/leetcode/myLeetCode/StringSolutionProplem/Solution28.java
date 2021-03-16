package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 实现 strStr()
 * 实现strStr()函数。
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
 *
 * 相关标签 双指针 字符串
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution28 {
    /**
     * 解题思路：利用substring()方法截取字符窜进行比较
     * 不断截取主串然后再比较
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int k = needle.length(); // 字符串长度
        for(int i=0;i<=haystack.length()-k;i++){
           // System.out.println("索引："+i+":"+haystack.substring(i,i+k));
            if (haystack.substring(i,i+k).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化方法一，
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_11(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if(n==0){
            return 0;
        }
        for(int i=0;i<h-n+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){ // 碰到与子串相同的第一个元素既开始进行比较，不需要一开始就拿子串来挨个进行比较，性能最优
                if(haystack.substring(i,i+n).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 一行代码搞定，牛批
     * 如果要这样写就没意思了，算法题能自己写的还是要自己写，尽量少用官方的api
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }



    /**
     * 2，逐个判断
     * 一般字符串匹配的时候，最简单的一种方式，就是子串从头开始和主串匹配。
     * 如果匹配失败，子串再次从头开始，而主串从上次匹配的下一个字符开始，代码如下
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_2(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                //如果不匹配，就回退，从第一次匹配的下一个开始，
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length())
                return i - j;
        }
        return -1;
    }

    /**
     * 逐个判断
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_3(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == n - 1) return i;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        String haystack="abc",needle = "c";
       // String haystack="hello",needle = "ll";
       // String haystack = "aaaaa", needle = "bba";
       // String haystack = "a", needle = "a";
       // System.out.println(str.substring(2,4));
        int in=new Solution28().strStr(haystack,needle);
        System.out.println("存在位置："+in);
    }

}
