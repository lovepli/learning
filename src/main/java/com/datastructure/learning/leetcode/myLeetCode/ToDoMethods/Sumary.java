package com.datastructure.learning.leetcode.myLeetCode.ToDoMethods;

/**
 * @author: 59688
 * @date: 2021/3/23
 * @description:  编程算法技巧总结
 */
public class Sumary {
    //TODO 1、编程算法中，什么时候用while语句，什么时候用for语句更适合？
    //这两种基本上是没有差别的，
    //但是如果先要执行一次再进行判断就用do while ，单纯for 和 while 没什么区别。
    //读取判断或者不用进行赋予初始值的时候更多用while，比如
    //while ((c=getchar()) != EOF)
    //当然你也可以用
    //for ( ; (c=getchar()) != EOF; )
    //或者
    //c=getchar();
    //for (; c != EOF; c=getchar())
    //或者
    //for(c=getchar(); c != EOF; c=getchar())
    //这几种千奇百怪的都是对的，只不过看起来不顺眼而已，编程多了就会条件反射用哪个了。

    //事实上,C语言中的While与For在流程是完全相同的,不过人们习惯在未知循环次数时用While,而已知时用For
    // 比如:1-100 For(i=1;i<=100;i++) 用While就是 i=1;while(i<=100) i++;

    //一般明确知道循环次数的时候用for，而只知道条件的时候一般用while
}

