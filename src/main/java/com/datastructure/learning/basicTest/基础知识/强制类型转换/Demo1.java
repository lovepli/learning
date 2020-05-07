package com.datastructure.learning.basicTest.基础知识.强制类型转换;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 *  总结：父类引用可以指向子类对象，子类引用不能指向父类对象。
 *  把子类对象直接赋给父类引用叫做向上转型，
 *  向上转型不用强制转型，如Father f1=new Son()，
 *  把指向子类对象的父类引用赋给子类引用叫做向下转型，要强制转型，如Son s1 = (Son)f1。
 *  向上转型会丢失子类特有的方法，但是子类overriding父类的方法，子类方法有效。
 */
public class Demo1 {

    //父类
    class Father {
        public void foo() {
            System.out.println("Father");
        }
    }
    //子类
  class Son extends Father {
        public void foo() { //重写
            System.out.println("Son");
        }
        public void dosth(){
            System.out.println("Son again");
        }
    }

    /**
     * 向上转型
     *  Father father = new Son();
     *  Son son = (Son)father;
     */
    public  void test(){



        //1.向上转型
        Father father = new Son(); //向上转型，即父类引用指向子类对象，此时子类对象的类型为父类的类型

        if(father instanceof Father){ //测试左边对象是否是右边类的实例，返回boolean类型的数据，作用上可以避免强制类型转换失败。
            System.out.println("father 是Father的实例");
        }

        father.foo(); //实际执行的是子类重写的方法Son
        // father.dosth();//编译错误

        //2.向下强制转换
        Son son = (Son)father; //把指向子类对象的父类引用赋给子类引用叫做向下转型，要强制转型
        son.foo(); //Son
        son.dosth(); //Son again

    }

    /**
     * instanceof的说明
     *  测试左边对象是否是右边类的实例，返回boolean类型的数据，作用上可以避免强制类型转换失败
     */
    public void f(){

        //向上转型
        Father father = new Son();

        if(father instanceof Father){
            System.out.println("father 是Father类的实例");//这个实际上是son对象，应该说是father的子类的实例吧？？？
        }

        //普通的
        Father father1 =new Father();

        if(father1 instanceof Father){
            System.out.println("father 是Father类的实例");
        }

        //普通的
        Son son=new Son();

        if(son instanceof Father){
            System.out.println("son 是Father类的子类的实例");
        }

    }

    /**
     * 向下强制转换，出错
     *  编译出错，ClassCastException
     *  Father father = new Father();
     *  Son son = (Son) father;
     */
    public void test2(){

        //2.运行出错ClassCastException
        Father father2=new Father();
        Son son2=(Son)father2;
    }


    public static void main(String[] args) throws Exception{

        Demo1 demo1=new Demo1();
        demo1.test();

    }


    /**
     *
     * 分析：
     * 举个例子来说明。比如系统中存在Father、Son两个对象。首先我们先构造一个Son对象，然后用一个Father类型变量引用它：
     *
     *       Father father = new Son();
     *
     *       在这里Son 对象实例被向上转型为father了，但是请注意这个Son对象实例在内存中的本质还是Son类型的，只不过它的能力临时被消弱了而已，如果我们想变强怎么办？将其对象类型还原！
     *
     *       Son son = (Son)father;
     *
     *       这条语句是可行的，其实father引用仍然是Father类型的，只不过是将它的能力加强了，将其加强后转交给son引用了，Son对象实例在son的变量的引用下，恢复真身，可以使用全部功能了。
     *
     *       前面提到父类强制转换成子类并不是总是成功，那么在什么情况下它会失效呢？
     *
     *       当引用类型的真实身份是父类本身的类型时，强制类型转换就会产生错误。例如：
     *
     *       Father father = new  Father();
     *
     *       Son son = (Son) father;
     *
     *       这个系统会抛出ClassCastException异常信息。
     *
     *    所以编译器在编译时只会检查类型之间是否存在继承关系，有则通过；而在运行时就会检查它的真实类型，是则通过，否则抛出ClassCastException异常。
     *
     *     所以在继承中，子类可以自动转型为父类，但是父类强制转换为子类时只有当引用类型真正的身份为子类时才会强制转换成功，否则失败。
     */
}
