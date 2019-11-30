package com.datastructure.learning.leetcode.stack;


//import java.util.Stack;  //引用java API中的栈Stack
//使用自定义的类EarrayStack
import com.datastructure.learning.datastucture.Stack.ArrayStack;


/**
 * leetcode 算法20
 * 数组栈 匹配括号
 * */
class Solution {

    public boolean isValid(String s){
       // Stack<Character> stack=new Stack<>()

       ArrayStack<Character> stack=new ArrayStack<>()
                ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("(){}[]"));
        System.out.println(new Solution().isValid("({)}[]"));
    }
}
