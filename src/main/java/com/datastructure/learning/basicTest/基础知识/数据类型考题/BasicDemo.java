package com.datastructure.learning.basicTest.基础知识.数据类型考题;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在java的逻辑运算符中，有这么四类，&&(短路与) &(与) | （或） || （短路或）
 *
 *   ++i 与 i++
 *
 *   取整/ 与 求余%
 *
 *
 * */



public class BasicDemo {


    /**
     *  基本数据类型和引用数据类型的比较，理解两者在内存中的分配规则
     *
     *  Java 字符串常量存放在堆内存还是JAVA方法区？
     *  JDK1.7 及之后版本的 JVM 已经将运行时常量池从方法区中移了出来，在 Java 堆（Heap）中开辟了一块区域存放运行时常量池。
     *  JDK1.8开始，取消了Java方法区，取而代之的是位于直接内存的元空间（metaSpace）。
     *
     *  在JDK6.0及之前版本，字符串常量池存放在方法区中在JDK7.0版本以后，字符串常量池被移到了堆中了。
     *  至于为什么移到堆内，大概是由于方法区的内存空间太小了。
     */
    public static void ff1(){
        String str="hello";  //
        String str2=new String("hello");  //str2地址在栈中分配，new String()在堆中动态分配，"hello"在方法区中
                                                  //字符串常量池存放的是对象的引用，不是对象，在Java中，对象都创建在堆内存中
                                                   //字符串常量池存在于堆内存中的永久代

        System.out.println(str==str2);  //false

        Integer in=3;  //自动装箱是jdk1.5之后的写法
        Integer in2=new Integer(3);
        int in3=3;
        System.out.println(in==in2);  //false
        System.out.println(in==in3); //true


    }
    public static void fff(){
        //char变量类型中可以存储一个中文汉子，因为Java中使用的编码是unicode
        char c='李';
       // char c2= "李攀";  //不能存储连个汉子

        //String Integer 重写了equqls()和hashCode(),toString()方法
        String s="haha";
        Integer i=100;

        String str ;

        str ="initial value";

        StringBuilder sb=new StringBuilder();

        sb.append("aaa");
        System.out.println(sb);  //aaa

        sb.append(111);
        System.out.println(sb);//aaa111

    }

    public static void  fff2(){

        String username="";
        if(username != null && !username.equals("")){
            System.out.println("!!!!!!!!!!");
        }else{
            System.out.println("用户名不能为空！！！");
        }

        try {
            String username2=null;
            //注意：两个判断逻辑的顺序不能交换，更不能用&运算符，因为第一个条件如
            //果不成立，根本不能进行字符串的 equals 比较，否则会产生 NullPointerException 异常
            if (!username2.equals("") & username2 != null ) {
                System.out.println("#################");
            }else{
                System.out.println("判断执行了");
            }
        }catch (Exception e){
            System.out.println("程序抛异常");
            e.printStackTrace();
        }
    }


    /**
     * Java中的异常处理机制
     * @return
     */
    public static int fff3(){

        try {
            int a = 1/0;
            return 1;
        } catch (Exception e) {
            return 2;
        }finally{
            return 3;
        }

    }


    /**
     * && 和& 以及|| 和|的区别
     */
    public static void f3(){

        if(10!=10&&10/0==0){
            System.out.println("条件满足2！！");
            //10！=10为false 第一个条件不满足，后面的条件就不再判断了 所以后面的就不执行了 最后没有输出
        }

//        if(10!=10&10/0==0){
//            System.out.println("条件满足1！！");
//              //10！=10为false，10/0==0会抛出异常，由于所有条件都需要判断，所以程序最终会出现异常错误
//        }

        if(10==10&&0==10&&2==3){
            //第一个为true第二个为false 结果为false 不能输出语句
            System.out.println("条件满足3！！");
        }

//        if(10==10&&10/0==0){
//            //第一个为true 第二个抛出异常 结果抛出异常 不能输出语句
//            System.out.println("条件满足3！！");
//        }

        if(10==10&&0==0){  //查询某个自然数区间的素数 多个条件的判断 使用这种 短路与
            //必须第一个，第二个...所有条件都为true  结果才为true  才能够打印输出
            System.out.println("条件满足4！！");
        }

        if(10==10&1==2&3==3){
            //三个条件只要有一个为false，结果为false，三个判断条件都需要执行，不能打印输出
            System.out.println("条件满足5！！");
        }
    }

    public static void f4(){
      if(10==10||10/0==0){
          //只要第一个条件为true，结果就为true，后面的条件就不用判断了，所以10/0==0这个条件就不必再判断了
          System.out.println("添加满足1！！");
      }

//      if(10==10|10/0==0){
//          //虽然10==10返回true，但是10/0==0这个条件是会抛出异常错误，所以当判断到第二个条件时就是会程序抛出异常
//          System.out.println("条件满足2！！！");
//      }

        if(1==1 |2==3 |3==4){
            //三个条件有一个条件为ture，结果为ture 三个判断条件都需要执行，能够打印输出语句
            System.out.println("条件满足4！！！");
        }
    }

/**
 *
 * int i=1,a=0;
 *      * i++ 先运算再赋值,例如 a=i++,先运算a=i,后运算i=i+1,所以结果是a==1
 *      * ++i 先赋值再运算,例如 a=++i,先运算i=i+1,后运算a=i,所以结果是a==2
 * */
    public static void f5(){
        int i=1,a=0;
        System.out.println("a++===>"+a++);//0
        System.out.println("a===>"+a);//1

      //  System.out.println("a=i++===> "+(a=i++)); //1
       // System.out.println("a="+a+","+"i="+i);  //a==1 ,i==2

       //System.out.println("a=++i===>"+(a=++i));  //2
      // System.out.println("a="+a+","+"i="+i); //a==2,i==2

    }

    public static void f6(){
        int y=0;
        int i=0;
        y=++y;   //1
        y=++y;   //2
        y=++y;   //3
        y=++y;   //4
        y=++y;   //5
        System.out.println("y="+y);  //5
        System.out.println("=====================");
        i=i++;    //0
        i=i++;    //0
        i=i++;    //0
        i=i++;    //0
        i=i++;    //0
        System.out.println("i="+i); //0
    }

    public static void f7(){
        int y=0;
        //注意"="是赋值,"=="才是相等
        y=++y;// y==0,++y==y+1; 结果y=++y == y+1 == 0+1 ==1
        y=++y;// y==1,++y==y+1; 结果y=++y == y+1 == 1+1 ==2
        y=++y;// y==2,++y==y+1; 结果y=++y == y+1 == 2+1 ==3
        y=++y;// y==3,++y==y+1; 结果y=++y == y+1 == 3+1 ==4
        y=++y;// y==4,++y==y+1; 结果y=++y == y+1 == 4+1 ==5
        System.out.println("y="+y);//5
        int i =0;
        // i==0,i++==0; 结果i=i++ == (记住先赋值后运算)i=i,i=i+1(由于是i++运算这里我们输出的i只取先赋值的结果也就是i=i)
        i=i++;
        i=i++;
        i=i++;
        i=i++;
        i=i++;
        System.out.println("i="+i);//0
        System.out.println("================");//1
    }


/**
 * Java中的取整数和求余数
 * */
    public static void f8( int a , int b) {
        int c=a/b;  //取整数
        int d=a%b;  //求余数
        System.out.println("c="+c+", d="+d); //c=3, d=1
    }



    public static void f2(){
        for(char c=0;c<128;c++) {
            if (Character.isLowerCase(c)) {
                System.out.println("value:" + (int) c + "Character:" + c);  //二十六个小写字母97-122
               // System.out.println("===========输出小写字母==========");
            }
            if (Character.isUpperCase(c)) {
                System.out.println("value:" + (int) c + "Character:" + c);  //二十六个大写字母65-90
               // System.out.println("===========输出大写字母==========");
            }
        }
    }

    /**
     * 循环结构--while循环
     */
    public static void f9(){
        int x = 10;
        while( x < 20 ) {
            System.out.print("value of x : " + x );
            x++;
            System.out.print("\n");
        }
    }

    /**
     * 循环结构--do... while循环
     * 循环语句至少执行一次
     */
    public static void f10(){
        int x = 10;
        do{
            System.out.print("value of x : " + x );
            x++;
            System.out.print("\n");
        }while( x < 20 );
    }

    /**
     * 循环结构--for循环
     *
     */
    public static void f11(){
        for(int x = 10; x < 20; x = x+1) { //这里不能写成x=x++  注意！！！
            System.out.print("value of x : " + x );
            System.out.print("\n");
        }
    }

    /**
     * 循环结构--增强for循环 Java5新特性
     *
     */
    public static void f12(){
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ){
            System.out.print( x );
            System.out.print(",");
        }
        System.out.print("\n");
        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name );
            System.out.print(",");
        }
    }

    /**
     * 循环--break关键字
     *break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。
     * break 跳出最里层的循环，并且继续执行该循环下面的语句。
     */
    public static void f13(){
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ) {
            // x 等于 30 时跳出循环
            if( x == 30 ) {
                break;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }

    /**
     * 循环--continue关键字
     *continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。
     * 在 for 循环中，continue 语句使程序立即跳转到更新语句。
     * 在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句。
     */
    public static void f14(){
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ) {
            if( x == 30 ) {
                continue;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }

    /**
     * 条件语句---if...else语句  嵌套的if...else语句
     *
     */
    public static void f15(){
        int x = 30;
        int y = 10;
        if( x == 30 ){
            if( y == 10 ){
                System.out.print("X = 30 and Y = 10");
            }
        }
    }

    /**
     * switch...case语句
     * switch 语句中的变量类型可以是： byte、short、int 或者 char。
     * 从 Java SE 7 开始，switch 支持字符串 String 类型了，
     * 同时 case 标签必须为字符串常量或字面量。
     *
     */
    public static void f16(){
        //char grade = args[0].charAt(0);
        char grade = 'C';

        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
                break;
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }



    public static void  f17(){

        //补充开发工具：
//####################################常用技巧##########################################
        //1。得到当前方法的名字
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);//main
//########################################################################################
        //2。字符串有整型的相互转换
        String a = String.valueOf(2); //integer to numeric string
        int i = Integer.parseInt(a); //numeric string to an int
        System.out.println(i);//2
//########################################################################################
        //3.转字符串到日期
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            Date date = format.parse( "2020-02-20 13:45:33");
            System.out.println(date); //Thu Feb 20 00:00:00 CST 2020
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {



     //   fff();
      //  f2();
       // f3();
       // f4();
      //  f5();
      //  f8(10,3);
      //  f11();

     //   System.out.println( "try catch finally 返回值："+fff3());  //3

        ff1();



    }

}
