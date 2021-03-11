package com.datastructure.learning.basicTest.基础知识.for循环及break和continue的区别;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class Demo {

    /**
     *
     * @param args
     * 1.For循环
     * 格式：
     * for( 初始语句  ; 执行条件  ; 增量 ){
     *     循环体
     * }
     * 执行顺序：1、初始语句  2、执行条件是否符合 3、循环体  4、增加增量
     *
     * 初始化语句只在循环开始前执行一次，每次执行循环体时要先判断是否符合条件，如果循环条件为true，则执行循环体，再执行迭代语句。
     * 所以对于for循环，循环条件总比循环体多执行一次。
     *
     * 注意：for循环的循环体和迭代语句不在一起（while和do-while是在一起的）所以如果使用continue来结束本次循环，迭代语句还有继续运行，而while和do-while的迭代部分是不运行的。
     *
     * 2.break和continue的区别和作用
     * break和continue都是用来控制循环结构的，主要是停止循环。
     *
     * break
     * 　　　　有时候我们想在某种条件出现的时候终止循环而不是等到循环条件为false才终止。
     * 　　　　这时我们可以使用break来完成。break用于完全结束一个循环，跳出循环体执行循环后面的语句。
     *
     * var str = "hello";
     * for (var item of str){
     *     if(item ==="l"){
     *         break
     *     }
     *     console.log(item);  // h e
     * }
     *
     * continue
     * 　　　　continue和break有点类似，区别在于continue只是终止本次循环，接着还执行后面的循环，break则完全终止循环。
     * 　　　　可以理解为continue是跳过当次循环中剩下的语句，执行下一次循环。
     *
     * var str = "hello";
     * for (var item of str){
     *     if(item ==="l"){
     *         continue
     *     }
     *     console.log(item);  // h e o
     * }
     */
    public static void main(String[] args) {
        String str="hello";
        char [] chars= str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='l'){
               // break;
                continue;
            }
            System.out.println(chars[i]);
        }



    }
}
