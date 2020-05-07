package com.datastructure.learning.basicTest.final关键字;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Test3 {

}

/**
 * final方法表示该方法不能被子类的方法重写，将方法声明为final，在编译的时候就已经静态绑定了，
 * 不需要在运行时动态绑定。final方法调用时使用的是invokespecial指令。
 */
class PersonalLoan{
    public final String getName(){
        return "personal loan" ;
    }
    public String getPassword(){
        return "123456";
    }
}

class CheapPersonalLoan extends PersonalLoan{

//    @Override
//    public final String getName(){
//        return"cheap personal loan";//编译错误，无法被重载
//    }

    @Override
    public String getPassword(){
        return "888888";
    }
    public String test() {
        return getName(); //可以调用，因为是public方法
    }
}
