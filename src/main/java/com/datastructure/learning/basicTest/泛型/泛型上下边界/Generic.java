package com.datastructure.learning.basicTest.泛型.泛型上下边界;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description: 泛型上下边界
 *
 * 在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
 *
 * 通过下面的两个例子可以看出：泛型的上下边界添加，必须与泛型的声明在一起
 *
 * <? extends T> 和 <? super T> 是 Java 泛型中的 “通配符（Wildcards）” 和 “边界（Bounds）” 的概念。
 * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）”。
 * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）”。
 */
@Slf4j
public class Generic<T> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    /**
     * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
     * <? extends E>:接收E类型或者E的子类型。
     * <? super E>:接收E类型或者E的父类型
     * @param obj
     */
    public void showKeyValue1(Generic<? extends Number> obj){
        log.info("泛型测试,key value is " + obj.getKey());
    }

    public void test(){
        Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Float> generic3 = new Generic<Float>(2.4f);
        Generic<Double> generic4 = new Generic<Double>(2.56);

        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //showKeyValue1(generic1);
        showKeyValue1(generic2);
        showKeyValue1(generic3);
        showKeyValue1(generic4);
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void main(String[] args) {

    }
}
