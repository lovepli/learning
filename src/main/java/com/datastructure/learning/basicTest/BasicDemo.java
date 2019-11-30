package com.datastructure.learning.basicTest;

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




    public static void main(String[] args) {

      //  f2();
       // f3();
       // f4();
      //  f5();
      //  f8(10,3);
        f11();
    }

}
