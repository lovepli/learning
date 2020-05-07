package com.datastructure.learning.basicTest.基础知识.数据类型考题;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description: Java 基础知识疑难点/易错点
 * https://github.com/Snailclimb/JavaGuide
 *
 */
public class Demo2 {


    /**
     * int 和 和 Integer 有什么区别？
     *整型包装类值的比较
     *所有整型包装类对象值的比较必须使用equals方法
     *
     * Java 为每个原始类型提供了包装类型：
     * - 原始类型: boolean， char， byte， short， int， long， float， double
     * - 包装类型： Boolean， Character， Byte， Short， Integer， Long， Float， Double
     */
    public static void f1(){
        Integer x = 3;         //将3自动装箱成 Integer类型
        Integer y = 3;
        int c=3;
        System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);//false  两个引用没有引用同一个对象
        System.out.println(a.equals(b));//true  比较的是内容，不是引用
        System.out.println(a == c);//true a自动拆箱成int类型再和c比较
    }

    /**
     * 查看源码 ，考察缓存问题
     * 简单的说，如果整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer 对象，而是直接引用常量池
     * 中的 Integer 对象，所以上面的面试题中 f1==f2 的结果是 true，而 f3==f4 的结果是 false
     */
    public static void f11(){
        Integer f1=100,f2=100,f3=150,f4=150;
        System.out.println(f1==f2);  //true
        System.out.println(f3==f4);  //false
    }


    /**
     * 考察类型转换 和 += 在程序的编译
     * short s1 = 1; s1 = s1 + 1; 有错吗?short s1 = 1; s1 += 1 有错吗
     *
     * 前者不正确，后者正确。 对于 short s1 = 1; s1 = s1 + 1;由于 1 是 int 类型，因此 s1+1 运算结果也是 int 型，
     * 需要强制转换类型才能赋值给 short 型。而 short s1 = 1; s1 += 1;可以正确编译，因为 s1+= 1;相当于 s1 =
     * (short)(s1 + 1);其中有隐含的强制类型转换
     */
    public static void f2(){
        short s1=1;
      //  s1= (s1+1); //报错
        s1= (short) (s1+1);
        System.out.println(s1);

    }

    public static void f3(){
        short s2=1;
        s2 +=1;
        System.out.println(s2);
    }

    public static void main(String[] args) {
        f3();

    }
}
