package com.datastructure.learning.basicTest.final关键字.最佳实践;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class FinalTest4 {

    /**
     * inal方法的三条规则
     * 规则1：final修饰的方法不可以被重写。
     *
     * 规则2：final修饰的方法仅仅是不能重写，但它完全可以被重载。
     *
     * 规则3：父类中private final方法，子类可以重新定义，这种情况不是重写。
     */

}
//test1
class FinalMethodTest {
    public final void test(){}
}
class Sub extends FinalMethodTest {
    // 下面方法定义将出现编译错误，不能重写final方法
    //public void test(){}
}

//test2
class Finaloverload {
    //final 修饰的方法只是不能重写，完全可以重载
    public final void test(){}
    public final void test(String arg){}
}

//test3
class PrivateFinalMethodTest{
    private final void test(){}
}
class Sub2 extends PrivateFinalMethodTest {
    // 下面方法定义将不会出现问题
    public void test(){}
}
