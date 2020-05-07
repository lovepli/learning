package com.datastructure.learning.basicTest.基础知识.数据类型考题.String字符串类型;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description: 参考知乎：https://zhuanlan.zhihu.com/p/52710835
 */
public class Demo {

    /**
     *
     */
    public static void ff1(){
        String str="hello";  //
        String str2=new String("hello");  //str2地址在栈中分配，new String()在堆中动态分配，"hello"在方法区中
        //字符串常量池存放的是对象的引用，不是对象，在Java中，对象都创建在堆内存中
        //字符串常量池存在于堆内存中的永久代
        System.out.println(str==str2);  //false
        //String的intern方法
        String str3=str2.intern();
        System.out.println(str3 == str);  //true



        Integer in=3;  //自动装箱是jdk1.5之后的写法
        Integer in2=new Integer(3);
        int in3=3;
        System.out.println(in==in2);  //false
        System.out.println(in==in3); //true

    }

    public static void main(String[] args) {
    ff1();
    }

    /**
     * String的intern方法的使用
     * 对于上面使用new创建的字符串对象，如果想将这个对象的引用加入到字符串常量池，可以使用intern方法。
     * 调用intern后，首先检查字符串常量池中是否有该对象的引用，如果存在，则将这个引用返回给变量，否则将引用加入并返回给变量。
     */

    /**
     * 字符串常量池：
     * 在JDK6.0及之前版本，字符串常量池存放在方法区中,在JDK7.0版本以后，字符串常量池被移到了堆中了。
     * 至于为什么移到堆内，大概是由于方法区的内存空间太小了。
     */

    /**
     * Java 字符串常量存放在堆内存还是JAVA方法区？
     * JDK1.7 及之后版本的 JVM 已经将运行时常量池从方法区中移了出来，在 Java 堆（Heap）中开辟了一块区域存放运行时常量池。
     * JDK1.8开始，取消了Java方法区，取而代之的是位于直接内存的元空间（metaSpace）。
     */

    /**
     * String s = new String("abc")
     * 这条语句创建了几个对象?
     *
     * 答案：共2个。第一个对象是”abc”字符串存储在常量池中，
     * 第二个对象在JAVA Heap堆中的 String 对象。这里不要混淆了s是放在栈里面的指向了Heap堆中的String对象。
     */

    /**
     *比较下列两种创建字符串的方法：
     *
     * String str1 = new String("abc");
     * String str2 = "abc";
     * 答案：第一种是用new()来新建对象的，它会在存放于堆中。每调用一次就会创建一个新的对象。 运行时期创建 。
     *
     * 第二种是先在栈中创建一个对String类的对象引用变量str2，然后通过符号引用去字符串常量池里找有没有”abc”,如果没有，
     * 则将”abc”存放进字符串常量池，并令str2指向”abc”，如果已经有”abc” 则直接令str2指向“abc”。“abc”存于常量池在 编译期间完成 。
     */

    /**
     * String s1 = new String("s1") ;
     * String s1 = new String("s1") ;
     * 上面一共创建了几个对象？
     *
     * 答案：答案:3个 ,编译期Constant Pool中创建1个,运行期heap中创建2个.
     * （用new创建的每new一次就在堆上创建一个对象，用引号创建的如果在常量池中已有就直接指向，不用创建）
     */


    /**
     * 比较字符串的‘==’和‘equals()’区别？
     *
     * 答案：
     *
     * ‘==’ 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。注意：
     *
     * 1、比较的是操作符两端的操作数是否是同一个对象。
     *
     * 2、两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过。
     *
     * 3、引用类型比较的是地址（即是否指向同一个对象），基本数据类型比较的是值，值相等则为true，如：int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆。
     *
     * ‘equals()’用来比较的是两个对象是否相等，由于所有的类都是继承自java.lang.Object类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地址，但String类中重写了equals方法， 比较的是字符串的内容 ，而不再是比较类在堆内存中的存放地址了。
     *
     * 总结：在没有重写equals方法的情况下，他们之间的比较还是基于他们在内存中的存放位置的地址值的，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同。String类中重写了equals方法，变成了字符串内容的比较。
     */

    /**
     * 1.单独使用””引号创建的字符串都是常量,编译期就已经确定存储到Constant Pool中；
     *
     * 2.使用new String(“”)创建的对象会存储到heap中,是运行期新创建的；
     *
     * 3.使用只包含常量的字符串连接符如”aa” + “aa”创建的也是常量,编译期就能确定,已经确定存储到String Pool中,String pool中存有“aaaa”；但不会存有“aa”。
     *
     * 4.使用包含变量的字符串连接符如”aa” + s1创建的对象是运行期才创建的,存储在heap中；只要s1是变量，不论s1指向池中的字符串对象还是堆中的字符串对象，运行期s1 + “aa”操作实际上是编译器创建了StringBuilder对象进行了append操作后通过toString()返回了一个字符串对象存在heap上。
     *
     * 5.String s2 = “aa” + s1; String s3 = “aa” + s1; 这种情况，虽然s2,s3都是指向了使用包含变量的字符串连接符如”aa” + s1创建的存在堆上的对象，并且都是s1 + “aa”。但是却指向两个不同的对象，两行代码实际上在堆上new出了两个StringBuilder对象来进行append操作。在Thinking in java一书中285页的例子也可以说明。
     *
     * 6.对于final String s2 = “111”。s2是一个用final修饰的变量，在编译期已知，在运行s2+”aa”时直接用常量“111”来代替s2。所以s2+”aa”等效于“111”+ “aa”。在编译期就已经生成的字符串对象“111aa”存放在常量池中。
     */
}
