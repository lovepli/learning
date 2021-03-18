package com.datastructure.learning.leetcode.myLeetCode.StringSolutionProplem.StringProplem;

import java.util.Stack;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 仅仅反转字母
 * 给定一个字符串S，返回“反转后的”字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含\ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution917 {

    /**
     * 思路：先遍历一遍字符串，去除其中的符号，使字母重新组成一个新的字符串，对新的字符串进行对称翻转操作，
     * 最后将新的字符串挨个放在原来字符串中是字母的位置，使用StringBuffer进行拼接，使用Character.isLetter()判断字符串中的字符是否是字母
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            if(Character.isLetter(S.charAt(i))){  //判断是否是字母
                sb.append(S.charAt(i));
            }
        }

        char[] chars =sb.toString().toCharArray();
       // System.out.println("去除符号后的数组："+ Arrays.toString(chars));
        char[] chars2= reverse(chars,0,chars.length-1);
       // System.out.println("去除符号后转换的数组："+ Arrays.toString(chars2));
        char [] chars0=S.toCharArray();
       // System.out.println("原数组："+ Arrays.toString(chars0));

        int x=0,y=0;
        while (y<chars0.length){ // dcba
            if(Character.isLetter(chars0[y])){
                chars0[y++]=chars2[x++];
            } else {
                y++;
            }
        }
        String res=new String(chars0);
        return res;
    }

    private char[] reverse(char[] chars,int start,int end){
        while (start < end) {
            char temp=chars[start]; // 存储第一个元素
            chars[start++] =chars[end]; //将最后一个元素赋值给第一个元素
            chars[end--] = temp;//将第一个元素赋值给最后一个元素
        }
        return chars;
    }


    /**
     * 官方解题
     * 方法 1：字母栈
     * 想法和算法
     * 将 s 中的所有字母单独存入栈中，所以出栈等价于对字母反序操作。（或者，可以用数组存储字母并反序数组。）
     * 然后，遍历 s 的所有字符，如果是字母我们就选择栈顶元素输出。
     * @param S
     * @return
     */
    public String reverseOnlyLetters_1(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }
        return ans.toString();
    }

    /**
     * 方法 2：反转指针
     * 想法
     * 一个接一个输出 s 的所有字符。当遇到一个字母时，我们希望找到逆序遍历字符串的下一个字母。
     * 所以我们这么做：维护一个指针 j 从后往前遍历字符串，当需要字母时就使用它。 TODO 思考：这种写法保证了符号的索引位置一直是保持不变的
     * @param S
     * @return
     */
    public String reverseOnlyLetters_2(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }



    public static void main(String[] args) {
       // String s="ab-cd";
       // String s="a-bC-dEf-ghIj";
        String s="Test1ng-Leet=code-Q!";
        System.out.println("得到的字符串为："+new Solution917().reverseOnlyLetters(s));
    }

}
