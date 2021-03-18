package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 最大重复子字符串
 * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
 * 单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
 *
 * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 *
 *
 * 示例 1：
 *
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 *
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 *
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-repeating-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1668 {

    /**
     * 思路，将字符串以word为分隔符进行分隔成字符串数组，然后遍历字符串数组，有几个Word就是k值
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        if(sequence.indexOf(word) == -1){
            return 0;
        }
        String ss= sequence.replaceAll(word,"");
       System.out.println(ss);
        int k=(sequence.length()-ss.length())/word.length();
    return 0;
    }

    /**
     * 字符串的特性，可以使用+号拼接成一个新的字符串
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating_1(String sequence, String word) {
        int count=0;
        String tmp=word;
        while(sequence.contains(word)){
            word+=tmp;// world=world+temp 变成了连个连续的world字符串组成的新的字符串
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

       String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba"; // 看来是题目理解错了，遇到这个大坑，记录一下
        // 要连续 aaabaaaab aaabaaaabaaaabaaaabaaaaba只有后面那截是
        System.out.println("最大重复值为："+new Solution1668().maxRepeating(sequence,word));
    }

}
