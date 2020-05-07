package com.datastructure.learning.basicTest.内部类.demo2;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:  成员内部类
 * 成员内部类是最普通的内部类，它的定义为位于另一个类的内部
 *   参考：https://www.cnblogs.com/dolphin0520/p/3811445.html
 */
public class Test {
    public static void main(String[] args)  {
        //创建成员内部类对象
        //第一种方式：
        Outter outter = new Outter();
      //  Outter.Inner inner = outter.new Inner();  //必须通过Outter对象来创建

        //第二种方式：
        Outter.Inner inner1 = outter.getInnerInstance();
        inner1.innerMethod();  //输出的radius结果为3.0,内部类出现和外部类同名的属性
        System.out.println(inner1.method());


    }
}

/**
 * 外部类
 */
class Outter {

    //私有 静态属性
    private double radius=0;
    private static int count =1;

    private Inner inner = null;

    //外部类构造方法
    public Outter() {

    }
    //外部类方法
    public String Method(){
        return "outter method hello world!";
    }
    //获取内部类实例的方法
    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    /**
     * 内部类
     */
    class Inner {

        private double radius=3;

        //内部类构造方法
        public Inner() {

        }

        public String method(){
            return "inner method  hello world";
        }

        //内部类方法
        public void innerMethod(){
            System.out.println(Method()); //访问的是外部类同名的方法 outter method hello world!  TODO 为什么这样的？？？
            System.out.println(radius); //3.0
            System.out.println("获取外部类的静态成员"+count); //1
            System.out.println("获取外部类的private成员"+Outter.this.radius); //0.0
            System.out.println("访问外部类的方法"+Outter.this.Method()); //outter method hello world!
        }
    }
}


/**
 * 1、成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 * 不过要注意的是，当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
 * 即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问：（外部类.this.成员变量，外部类.this.成员方法）
 * 2、虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。在外部类中如果要访问成员内部类的成员，
 * 必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：
 * 3、成员内部类是依附外部类而存在的，也就是说，
 * 如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。创建成员内部类对象的一般方式如上：
 */
