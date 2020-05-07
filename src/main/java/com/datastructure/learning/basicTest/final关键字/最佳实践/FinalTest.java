package com.datastructure.learning.basicTest.final关键字.最佳实践;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class FinalTest {
    /**
     * 关于空白final
     * final修饰的变量有三种：静态变量、实例变量和局部变量，分别表示三种类型的常量。
     * 　另外，final变量定义的时候，可以先声明，而不给初值，这中变量也称为final空白，无论什么情况，编译器都确保空白final在使用之前必须被初始化。 　
     * 但是，final空白在final关键字final的使用上提供了更大的灵活性，为此，一个类中的final数据成员就可以实现依对象而有所不同，却有保持其恒定不变的特征。
     */

    final int p;
    final int q=3;
    FinalTest(){
        p=1;
    }
    FinalTest(int i){
        p=i;//可以赋值，相当于直接定义p
       // q=i;//报错，不能为一个final变量赋值
    }
}
