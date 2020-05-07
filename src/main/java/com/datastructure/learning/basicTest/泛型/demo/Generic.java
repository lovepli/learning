package com.datastructure.learning.basicTest.泛型.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description: 一个最普通的泛型类：
 */
@Slf4j
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void f1(){
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        log.info("泛型测试,key is " + genericInteger.getKey());
        log.info("泛型测试,key is " + genericString.getKey());
    }

    /**
     * 定义的泛型类，就一定要传入泛型类型实参么？并不是这样，在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，
     * 此时泛型才会起到本应起到的限制作用。
     * 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型
     *
     * 注意：
     * 1、泛型的类型参数只能是类类型，不能是简单类型。
     * 2、不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
     *  if(ex_num instanceof Generic<Number>){
     *  }
     */
    public static void f2(){
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        log.info("泛型测试,key is " + generic.getKey());
        log.info("泛型测试,key is " + generic1.getKey());
        log.info("泛型测试,key is " + generic2.getKey());
        log.info("泛型测试,key is " + generic3.getKey());

          //报错
//        if( generic1 instanceof Generic<Number>){
//
//        }
//
//        if( generic instanceof Generic<String>){
//
//        }
    }

    public static void showKeyValue(Generic<Number> obj){
        log.info("泛型测试,key is " + obj.getKey());
    }

    /**
     * 泛型通配符
     * 我们知道Ingeter是Number的一个子类，同时在特性章节中我们也验证过Generic<Ingeter>与Generic<Number>实际上是相同的一种基本类型。那么问题来了，在使用Generic<Number>作为形参的方法中，能否使用Generic<Ingeter>的实例传入呢？在逻辑上类似于Generic<Number>和Generic<Ingeter>是否可以看成具有父子关系的泛型类型呢？
     *
     * 通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
     */
    public  static void f3(){
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        showKeyValue(gNumber);
      //  showKeyValue1(gInteger);   编译出错

        // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>
        // showKeyValue(gInteger);
    }

    /**
     *
     * 回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理Generic<Integer>类型的类，这显然与java中的多台理念相违背。因此我们需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型。由此类型通配符应运而生。
     *
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     *
     * 可以解决当具体类型不确定的时,这个通配符就是 ?  ；当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
     */
    public static void showKeyValue1(Generic<?> obj){
        log.info("泛型测试,key is " + obj.getKey());
    }

    public static void f4(){

    }
    public static void main(String[] args) {

        f3();
    }
}
