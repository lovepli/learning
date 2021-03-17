package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

import com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.Solution14;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution459 {

    /**
     * 思路：进行字符串截取，截取字符串第一个字符，依次增加截取的字符串的长度，进行翻倍拼接组成一个新的字符串，然后再与旧的字符串进行比较是否相等
     * 注意：子串长度不能为1和s.length()
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
       if(s.length()==1){
           return false;
       }
       int i=1;
       String str="";
while (i<=s.length()/2){
        str=s.substring(0,i); // 截取字符串
    System.out.println("截取的字符串："+str);
       int k= s.length()%i; // 余数
       int l=s.length()/i; // 整除
       StringBuffer sb=new StringBuffer();
        if(k==0){
           for(int j=0;j<l;j++){
               sb.append(str);
           }
            System.out.println("重新组成的字符串："+sb.toString());
           if(sb.toString().equals(s)){    //aabbaabb
               return true;
           }
        }
        i++;
}
        return false;
    }

    /**
     * 官方说明一：枚举
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern_1(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符窜匹配
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern_2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }




    public static void main(String[] args) {
      //  String str="12345";
      //  System.out.println(str.substring(0,5));
        String s="aba";
        System.out.println("是否存在子串："+new Solution459().repeatedSubstringPattern(s));
    }

}
