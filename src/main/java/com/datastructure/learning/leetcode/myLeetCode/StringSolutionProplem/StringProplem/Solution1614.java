package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 括号的最大嵌套深度
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 *
 * 示例 1：
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 *
 * 示例 2：
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "1+(2*3)/(2-1)"
 * 输出：1
 *
 * 示例 4：
 * 输入：s = "1"
 * 输出：0
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * 题目数据保证括号表达式 s 是 有效的括号表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1614 {

    /**
     * 思路：将字符串全部过滤截取括号组成一个新的字符串，例如"()(())((()))",然后遍历新的字符串，从第一个"("开始，如果下一个是")",记录为1，接着遍历，碰到“(”
     * ,往下走，如果还是“(”,记录为2，直到碰到”)“
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        // 字符串中不存在“(”和“)”
        if(s.indexOf('(')== -1 && s.indexOf(')')== -1){
            return 0;
        }

        StringBuffer sb=new StringBuffer();
        for (char ch:s.toCharArray()){
            if(ch=='(' || ch==')'){
                sb.append(ch);
            }
        }
        String s1=sb.toString(); // 新的字符串
       // System.out.println("新的字符串为："+s1);

        // 新建一个栈stack,通过入栈出栈操作来控制，遍历字符串，一直是“(”的就入栈，直到碰到“)”,就出栈
        Stack<Character> stack=new Stack<Character>();
        Set<Integer> set=new HashSet<>();

        int i=0;
        int num=0;
        // 取出栈入栈的最大连续数值
            while(i<s1.length()){
                // 没有左右边界"(",")"的处理
                if (s1.charAt(i)=='('){
                    stack.push(s1.charAt(i++));// 入栈
                    num++; //次数
                } else {
                    stack.pop();
                    i++;
                    num--;
                }
               // System.out.println("连续出入栈次数："+num);
                set.add(num); //每一轮出栈，在再次碰到”(“之前，记录出栈的次数
            }

        // 找出set集合中最大的数字
        int []  ints=new int[set.size()];
        // set转数组
        int index=0;
          for(Integer in:set){
              ints[index++]=in;
          }
          // 查找ints数组中的最大值
         Arrays.sort(ints);
        //System.out.println("出栈次数数组："+Arrays.toString(ints));
       int mux=ints[ints.length-1];
     return mux;
    }


    /**
     *
     * @param s
     * @return
     */
    public int maxDepth_1(String s) {
        int r = 0, n = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') n++;
            if(s.charAt(i) == ')') n--;
            if(r < n) r = n;
        }
        return r;
    }

    public int maxDepth_11(String s) {
        int deep=0,ans=0;
        for(char c:s.toCharArray()){
            if(c=='(')deep++;
            else if(c==')')deep--;
            ans=Math.max(ans,deep);
        }
        return ans;
    }






    public static void main(String[] args) {
        //String tr="()(())(((())))((()))";
    // String s = "(1+(2*3)+((8)/4))+1"; // 3
      //  String s = "(1)+((2))+(((3)))"; // 3
   //String s = "1+(2*3)/(2-1)"; //1
       // String s="1";
    //  String s="1+(1+1)"; //1
    String s="8*((1*(5+6))*(8/6))"; //3
        System.out.println("字符串最大嵌套深度"+new Solution1614().maxDepth(s));

    }

}
