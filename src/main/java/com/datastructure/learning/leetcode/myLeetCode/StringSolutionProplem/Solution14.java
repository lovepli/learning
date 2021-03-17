package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 相关标签 字符串
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution14 {

    /**
     * 哎，想着遍历一次，然后第一个字符串取第一个字符和后面的字符串的第一个进行比较，然后继续下一伦，取第一个字符串的第二个字符和后面的字符串的第二个一次比较，然后就走入了死胡同...没有思路！！！
     * 现在想想，其实我想要的解题思路就是方法二这种
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        for(int i=0;i<strs.length;i++){
            //if(strs[i].substring(1,i+1).equals(strs[i+1].substring(i,i+1))){
            //
            //}


        }
      return "";
    }



    /**
     * 1，解法一
     *先取第一个字符串当做他们的公共前缀
     * 然后找出他和第2个字符串的公共前缀，然后再用这个找出的公共前缀分别和第3个，第4个……判断
     * @param strs
     * @return
     */
    public String longestCommonPrefix_1(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    /**
     * 2，解法二
     * 解题思路
     * 先取第一个字符串
     * 依次按照第一个字符串的每个字符，进行纵向对比
     * 一旦别的字符串长度不够，或者其他字符串和第一个字符串第i个字符不一致
     * 返回第一个字符串的部分截取，如第i个不满足条件，就取[0，i-1]即substring(0,i)
     * 全都满足，就返回第一个字符串
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix_2(String[] strs) {
        // 纵向扫描
        if(strs == null || strs.length ==0){
            return "";
        }
        // 以第一个字符串为基准，进行纵向扫描
        int length = strs[0].length();
        // 纵向深度
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c =  strs[0].charAt(i);
            // 以第一个字符串第i个进行向下扫描、
            for (int j = 1; j < count; j++) {
                //如果其他字符串长度不够，或者不为c，返回第一个数组的部分截取，如第i个不满足条件，就取[0，i-1]即substring(0,i)
                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        // 最大不超过第一个字符串
        return strs[0];
    }






    public static void main(String[] args) {
       String []  strs = {"flower","flow","flight"};
       String s=new Solution14().longestCommonPrefix(strs);
        System.out.println("最长公共前缀为："+s);
    }

}
