package com.datastructure.learning.basicTest.基础知识.数据类型考题.String字符串类型;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 */
public class demo2 {

    public static void main(String[] args) {
        String s1 = "sss111";
        String s2 = "sss111";
        System.out.println(s1 == s2); //结果为true
        String s11 = new String("sss111");
        String s22 = "sss111";
        System.out.println(s11 == s22); //结果为false
        String s0 = "111";              //pool
        String s111 = new String("111");  //heap
        final String s222 = "111";        //pool
        String s3 = "sss111";           //pool
        String s4 = "sss" + "111";      //pool
        String s5 = "sss" + s0;         //heap
        String s6 = "sss" + s1;         //heap
        String s7 = "sss" + s2;         //pool
        String s8 = "sss" + s0;         //heap

        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //false
        System.out.println(s3 == s7);   //true
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s8);   //false
    }


    /**
     * 1.单独使用””引号创建的字符串都是常量,编译期就已经确定存储到Constant Pool中；
     *
     * 2.使用new String(“”)创建的对象会存储到heap中,是运行期新创建的；
     *
     * 3.使用只包含常量的字符串连接符如”aa” + “aa”创建的也是常量,编译期就能确定,已经确定存储到String Pool中,String pool中存有“aaaa”；但不会存有“aa”。
     *
     * 4.使用包含变量的字符串连接符如”aa” + s1创建的对象是运行期才创建的,存储在heap中；只要s1是变量，不论s1指向池中的字符串对象还是堆中的字符串对象，运行期s1 + “aa”操作实际上是编译器创建了StringBuilder对象进行了append操作后通过toString()返回了一个字符串对象存在heap上。
     *
     * 5.String s2 = “aa” + s1; String s3 = “aa” + s1; 这种情况，虽然s2,s3都是指向了使用包含变量的字符串连接符如”aa” + s1创建的存在堆上的对象，并且都是s1 + “aa”。但是却指向两个不同的对象，两行代码实际上在堆上new出了两个StringBuilder对象来进行append操作。在Thinking in java一书中285页的例子也可以说明。
     *
     * 6.对于final String s2 = “111”。s2是一个用final修饰的变量，在编译期已知，在运行s2+”aa”时直接用常量“111”来代替s2。所以s2+”aa”等效于“111”+ “aa”。在编译期就已经生成的字符串对象“111aa”存放在常量池中。
     */
}
