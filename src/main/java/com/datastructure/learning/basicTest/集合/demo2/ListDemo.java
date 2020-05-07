package com.datastructure.learning.basicTest.集合.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class ListDemo {
    /**
     * 问题：List list1=new ArrayList()和 ArrayList list2 =new ArrayList()的区别？
     * <p>
     * List list1 = new ArrayList();这句创建了一个 ArrayList 的对象后把上溯到了 List。此时它是一个 List 对象了，有些
     * ArrayList 有但是 List 没有的属性和方法，它就不能再用了。而 ArrayList list2=new ArrayList();创建一对象则保留了
     * ArrayList 的所有属性。 所以需要用到 ArrayList 独有的方法的时候不能用前者。
     */

    List list = new ArrayList();
    ArrayList arrayList = new ArrayList();
    // list.trimToSize(); //错误，没有该方法。
    // arrayList.trimToSize(); //ArrayList 里有该方法。


    /**
     * 为什么一般都使用 List list = new ArrayList() ,而不用 ArrayList alist = new ArrayList()呢？
     *
     * 问题就在于List有多个实现类，如 LinkedList或者Vector等等，现在你用的是ArrayList，也许哪一天你需要换成其它的实现类呢？
     * 这时你只要改变这一行就行了：List list = new LinkedList(); 其它使用了list地方的代码根本不需要改动。
     * 假设你开始用 ArrayList alist = new ArrayList(), 这下你有的改了，特别是如果你使用了 ArrayList特有的方法和属性。 
     * 如果没有特别需求的话,最好使用List list = new LinkedList(); ,便于程序代码的重构. 这就是面向接口编程的好处
     */

    /**
     * 2.为什么可以声明父类，而实例化子类呢？
     * 这个语句其实就相当于隐式声明了一个子类对象然后将其隐式转化为父类的的类型，所以
     * 这里的p是父类Person的对象，这样做的好处是比如你声明了一个接口或者抽象类，然后要使用他的实例化对象，
     * 但是抽象类是不能直接实力化的，所以就需要靠子类来帮忙了
     */
    Person2 p2 = new Student2();

}

//抽象类
abstract class  Person2 {

    //抽象方法 子类必须继承，否则报错
    public abstract void fun2();

    //非抽象方法
    public void fun1(){
        System.out.println("抽象父类的非抽象特有方法 -- 子类不能继承");
    }

    //构造方法
    public Person2(){
        System.out.println("抽象父类的构造方法");
    }

}

class Student2 extends Person2 {

    public Student2(){
        System.out.println("子类的构造方法");
    }

    private void f(){
        System.out.println("这是子类的特有的方法");
    }

    @Override
    public void fun2() {
        System.out.println("这是子类继承的方法");
    }


    public static void main(String[] args) {
        Person2 p2 = new Student2();
        p2.fun1();

        Student2 stu=new Student2();
        stu.fun2();

    }
}






