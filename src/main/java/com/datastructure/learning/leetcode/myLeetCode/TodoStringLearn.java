package com.datastructure.learning.leetcode.myLeetCode;

/**
 * @author: 59688
 * @date: 2021/3/15
 * @description: 字符串相关操作
 */
public class TodoStringLearn {

    /**
     * 遍历一个字符串的每一个字母
     */
    public void test1(){
        String str = "asdfghjkl";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
        }
    }

    /**
     * 方法一
     * String转换为char
     * 在Java中将String转换为char是非常简单的。
     * 1. 使用String.charAt(index)（返回值为char）可以得到String中某一指定位置的char。
     * 2. 使用String.toCharArray()（返回值为char[]）可以得到将包含整个String的char数组。这样我们就能够使用从0开始的位置索引来访问string中的任意位置的元素。
     */
    public void test2(){
        String str = "asdfghjkl";
        char[] c=str.toCharArray();
        for(char cc:c){
        //...//cc直接用了
        }
    }

    /**
     * 方法二
     * 补充subStr()
     * str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
     * str＝str.substring(int beginIndex，int endIndex);截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;这是一个很常见的函数，他的所用
     *
     * 扩展trim()
     * trim()是去掉字符序列左边和右边的空格，如字符串
     * str = " ai lafu yo ";
     * str = trim(str);
     * 输出的将是"ai lafu yo"
     */
    public void test3(){
        String str = "asdfghjkl";
        for(int i=0;i<str.length();i++){
            String subStr = str.substring(i, i+1);
            System.out.println(subStr);
        }
    }

    /**
     * char转换为String
     * 将char转换为String大致有6种方法。总结如下：
     */
    public  void charToString(){
       //1. String s = String.valueOf('c'); //效率最高的方法

       //2. String s = String.valueOf(new char[]{'c'}); //将一个char数组转换成String

       //3. String s = Character.toString('c');
       //// Character.toString(char)方法实际上直接返回String.valueOf(char)

       //4. String s = new Character('c').toString();

       //5. String s = "" + 'c';
// 虽然这个方法很简单，但这是效率最低的方法
// Java中的String Object的值实际上是不可变的，是一个final的变量。
// 所以我们每次对String做出任何改变，都是初始化了一个全新的String Object并将原来的变量指向了这个新String。
// 而Java对使用+运算符处理String相加进行了方法重载。
// 字符串直接相加连接实际上调用了如下方法：
// new StringBuilder().append("").append('c').toString();

       // 6. String s = new String(new char[]{'c'});
    }

    /**
     * 字符串转int
     * 将 String 类型转化为 int 类型时,需要使用 Integer 类中的 parseInt() 方法或者 valueOf() 方法进行转换.
     *
     */
    public void StringToInt(){
        String str = "123";
        try {
            int a = Integer.parseInt(str);
         // int b = Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            //在转换过程中需要注意,因为字符串中可能会出现非数字的情况,所以在转换的时候需要捕捉处理异常
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new TodoStringLearn().test3();
    }
}
