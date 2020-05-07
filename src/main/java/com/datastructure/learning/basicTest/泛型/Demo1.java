package com.datastructure.learning.basicTest.泛型;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 */
@Slf4j
public class Demo1 {

    //private static final Logger LOGGER = LogFactory.getLoggger(demo1.class);

    /**
     * ArrayList可以存放任意类型，例子中添加了一个String类型，添加了一个Integer类型，
     * 再使用时都以String的方式使用，因此程序崩溃了。
     * 为了解决类似这样的问题（在编译阶段就可以解决），泛型应运而生。
     */
    public static void f(){
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            log.info("泛型测试","item = " + item);
        }
        /**
         * 异常
         * item = aaaa
         * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
         */
    }

    //我们将第一行声明初始化list的代码更改一下，编译器会在编译阶段就能够帮我们发现类似这样的问题
    public static void f2(){
        List<String> arrayList = new ArrayList<String> ();
        arrayList.add("aaaa");
        //arrayList.add(100); //在编译阶段，编译器就会报错

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("item = " + item);
        }
    }

    /**
     * 特性：泛型只在编译阶段有效
     *
     * 通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。在编译过程中，
     * 正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
     * 也就是说，泛型信息不会进入到运行时阶段。
     * 总结一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    public static void f3(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        //验证泛型擦除
        if(classStringArrayList.equals(classIntegerArrayList)){
            log.info("泛型测试,"+"类型相同");
        }
    }

    /**
     * 泛型擦除
     * 我接下来要把一个数字1插入到这三段不一样的代码中了。
     *
     * //深入查案list源码
     * 带来的问题：
     * （1） 强制类型转化
     * 这个问题的结果我们已经在上述文章中提及到了，通过反射的方式去进行插入的时候，我们的数据就会发生错误。
     * 如果我们在一个List<Integer>中在不知情的情况下插入了一个String类型的数值，那这种重大错误，我们该找谁去说呢。
     * （2）引用传递问题
     *
     */
    public static void f4(){

        List list = new ArrayList();
        List listString = new ArrayList<String>();
        List listInteger = new ArrayList<Integer>();

        try {
            list.getClass().getMethod("add", Object.class).invoke(list, 1);
            listString.getClass().getMethod("add", Object.class).invoke(listString, 1);
            // 给不服气的读者们的测试之处，你可以改成字符串来尝试。
            listInteger.getClass().getMethod("add", Object.class).invoke(listInteger, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("list size:" + list.size());  //list size:1
        System.out.println("listString size:" + listString.size()); //listString size:1
        System.out.println("listInteger size:" + listInteger.size()); //listInteger size:1
    }



    public static void main(String[] args) {
       // f();
      //  f2();
        f3();

    }
}
