package com.datastructure.learning.basicTest.内部类.demo2.考题;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class Test2{
    public static void main(String[] args){
        // 初始化Bean1
        //(1)
        Test2 test2 = new Test2();
        Test2.Bean1 bean1 = test2.new Bean1();

        bean1.I++;
        // 初始化Bean2
       // (2)
        Test2.Bean2 bean2 = new Test2.Bean2();  //注意不能这样写  Test2.Bean2 bean2 = new Test2().Bean2();
        bean2.J++;
        //初始化Bean3
       // (3)
        Bean bean = new Bean();

        Bean.Bean3 bean3 =  bean.new Bean3();
        bean3.k++;
    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}

/**
 * 从前面可知，对于成员内部类，必须先产生外部类的实例化对象，才能产生内部类的实例化对象。
 * 而静态内部类不用产生外部类的实例化对象即可产生内部类的实例化对象。
 *
 * 　　创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
 *
 * 　　创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
 */
