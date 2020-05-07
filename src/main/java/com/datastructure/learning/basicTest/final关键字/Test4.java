package com.datastructure.learning.basicTest.final关键字;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 * final类
 * final类不能被继承，final类中的方法默认也会是final类型的，java中的String类和Integer类都是final类型的。
 */
public class Test4 {
    final char[]a = {'a'};
    final int[]b = {1};

    public static void main(String[] args) {
        //引用没有被final修饰，所以是可变的。
        //final只修饰了Fi类型，即Fi实例化的对象在堆中内存地址是不可变的。
        //虽然内存地址不可变，但是可以对内部的数据做改变。
        Fi f = new Fi();
        f.a = 1;

        System.out.println(f.a);
        System.out.println(f);
        f.a = 2;
        System.out.println(f.a);
        System.out.println(f);
        //改变实例中的值并不改变内存地址。

        Fi ff = f;
        //让引用指向新的Fi对象，原来的f对象由新的引用ff持有。
        //引用的指向改变也不会改变原来对象的地址
        f = new Fi();
        System.out.println("#########"+f);
        System.out.println("#########"+ff);

        //引用被final修饰的情况
        final Fi f2 = new Fi();
       // f2=new Fi();// 报错 final修饰引用，所以引用是不可变的

       // TODO 总结：//final修饰类型，实例对象在堆中的内存地址不可变，final修饰对象的引用，引用不可变

    }

}
//final修饰类型
final class Fi {
    public int a;
}

class Si{
    //一般情况下final修饰的变量一定要被初始化。
    //只有下面这种情况例外，要求该变量必须在构造方法中被初始化。
    //并且不能有空参数的构造方法。
    //这样就可以让每个实例都有一个不同的变量，并且这个变量在每个实例中只会被初始化一次
    //于是这个变量在单个实例里就是常量了。
    final int s ;
    Si(int s) {
        this.s = s;
    }
}

class Bi {
    final int a = 1;
    final void go() {
        //final修饰方法无法被继承
    }
}

class Ci extends Bi {
    final int a = 1;
//        void go() {
//            //final修饰方法无法被继承
//        }
}

final class PersonalLoan2{}

//class CheapPersonalLoan extends PersonalLoan2 {  //编译错误，无法被继承
//}



