package com.datastructure.learning.basicTest.内部类.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class Test22 {

    //类 WithInner
    class WithInner {
        //成员内部类 Inner
        class Inner{

        }
    }

    //类 InheritInner 继承 类 WithInner 的成员内部类 类Inner
    class InheritInner extends WithInner.Inner {

        // 构造器InheritInner() 是不能通过编译的，一定要加上形参
        InheritInner(WithInner wi) {
            wi.super(); //必须有这句调用
        }
    }


    public  void method(){
        WithInner wi = new WithInner();
        InheritInner obj = new InheritInner(wi);
    }

    /**
     * 补充一点知识：关于成员内部类的继承问题。一般来说，内部类是很少用来作为继承用的。但是当用来继承的话，要注意两点：
     *
     * 　　1）成员内部类的引用方式必须为 Outter.Inner.
     *
     * 　　2）构造器中必须有指向外部类对象的引用，并通过这个引用调用super()。这段代码摘自《Java编程思想》
     * @param args
     */
    public static void main(String[] args) {
        Test22 t=new Test22();
        t.method();
    }
}
