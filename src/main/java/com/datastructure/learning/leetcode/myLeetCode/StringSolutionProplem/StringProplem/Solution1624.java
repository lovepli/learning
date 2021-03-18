package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 两个相同字符之间的最长子字符串
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 * 示例 1：
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 *
 * 示例 2：
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 *
 * 示例 3：
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 *
 * 示例 4：
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *
 * 提示：
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1624 {

    /**
     * 方法一：hash表解题
     * hashmap记录一下最前面的相同字符的索引
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int max=-1; //不存在则返回-1
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                continue;
            }
            Integer integer = map.get(s.charAt(i));
            max=Math.max(max,i-integer-1);
        }
        return max;
    }

    /**
     * 两层循环,不断更新max的值,直到最大为止
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters_1(String s) {
        int max =  0;
        char[] arr =s.toCharArray();
        //标记用来判断有没有两个相同的字符
        int flag = 0;
        for(int i =0;i<arr.length-1;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    flag = 1;
                    //计算最大长度 j-i-1
                    max =  Math.max(max,j-i-1);

                }
            }
        }
        if(flag==0){
            return -1;
        }else{
            return max;
        }
    }


}
