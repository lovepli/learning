package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 交替合并字符串
 *
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 *
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 *
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-strings-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1768 {

    /**
     * 思路：先判断两个字符串的长度，将长度较长的一个字符串截取多余的字符，最后来拼接，
     * 第一个字符串是0,2,4..偶数位放置，两外一个字符串是奇数位放置
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {


        int k1=word1.length();
        int k2=word2.length();

        int ln=0;
        StringBuffer sb=new StringBuffer();
        if(k1>=k2){
            ln=k2*2; //新数组长度(不包含最后的元素)
            String ss=word1.substring(k2,k1);

            int z=0;
            int z1=0;
            while (z<k2 && z1<ln){
                if(z1%2==0){ // 偶数位
                    sb.append(word1.charAt(z));
                    z1++;
                }
                if(z1%2==1){ //奇数位
                    sb.append(word2.charAt(z));
                    z1++;
                }
                z++;
            }
            // 追加最后面的几个数
            sb.append(ss);
        }else {
            ln=k1*2; //新数组长度
            String ss=word2.substring(k1,k2);
            System.out.println("要追加的字符串："+ss);

            int z=0;
            int z1=0;
            while (z<k1 && z1<ln){
                if(z1%2==0){ // 偶数位
                    sb.append(word1.charAt(z));
                    z1++;
                }
                if(z1%2==1){ //奇数位
                    sb.append(word2.charAt(z));
                    z1++;
                }
                z++;
            }
            // 追加最后面的几个数
            sb.append(ss);
        }
    return sb.toString();
    }

    /**
     * 秒！
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately_1(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length() ; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       // String str="12345";
        //System.out.println(str.substring(3,5));
        //String word1 = "abc", word2 = "pqr"; //apbqcr
        String word1 = "cf", word2 = "eee"; //"cefee"
        System.out.println("交叉新组成的字符串为："+new Solution1768().mergeAlternately(word1,word2));
    }

}
