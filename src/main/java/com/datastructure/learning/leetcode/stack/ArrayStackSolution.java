package com.datastructure.learning.leetcode.stack;


//import java.util.Stack;  //引用java API中的栈Stack
//使用自定义的类EarrayStack
import com.datastructure.learning.datastucture.Stack.ArrayStack;


/**
 * 知识点：栈的另一个应用：括号匹配
 * leetcode 算法20
 * 数组栈 匹配括号
 *  核心思想：对前一个char和当前的char同时进行校验，
 * */
class ArrayStackSolution {

    public boolean isValid(String s){
       // Stack<Character> stack=new Stack<>()
        //新建一个ArrayStack容器，用来存储元素 这里栈中存储的是char,所以类型是Character
       ArrayStack<Character> stack=new ArrayStack<>();

       //遍历字符串得到index位置的字节
        for (int i = 0; i < s.length(); i++) {
            //返回char指定索引处的值
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                //入栈
                stack.push(c);
            } else {
                //前面的c不满足条件，不能入栈，直接返回false 因为前一个char不符合条件，即不能拿到，所以就不能进行同时校验
                if (stack.isEmpty()) {
                    return false;
                }
                //出栈 得到的是上一个入栈的char
                char topChar = stack.pop();
                //此时的c不是上一个入栈的char,是字符串的后一个索引位置的char,
                // 所以这里的意思是如果后一个字符为'）',但是前一个字符不为'（',那么不满足要求
                //核心思想：对前一个char和当前的char同时进行校验，我觉得直接用数组也可以做到，自己试试看
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
        //作为参数的字符串没有"（）[] {}"这些内容，则不会有元素入栈，不满足条件
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        //这里字符串规则是前一个char和后一个char的关系是正反括号的关系，注意观察！所以规律是要进行前后char的验证，TODO 如果需要你验证"{[()]}",你该怎怎么写？
        System.out.println(new ArrayStackSolution().isValid("(){}[]()"));
        System.out.println(new ArrayStackSolution().isValid("({)}[]"));
        System.out.println(new ArrayStackSolution().isValid("  ({)}[]"));
    }
}
