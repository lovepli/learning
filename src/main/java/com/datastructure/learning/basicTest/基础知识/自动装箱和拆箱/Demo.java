package com.datastructure.learning.basicTest.基础知识.自动装箱和拆箱;

import java.util.ArrayList;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:  参考：https://droidyue.com/blog/2015/04/07/autoboxing-and-autounboxing-in-java/
 */
public class Demo {

    /**
     *何时发生自动装箱和拆箱
     * 自动装箱和拆箱在Java中很常见，比如我们有一个方法，接受一个对象类型的参数，如果我们传递一个原始类型值，
     * 那么Java会自动讲这个原始类型值转换成与之对应的对象。最经典的一个场景就是当我们向ArrayList这样的容器中
     * 增加原始类型数据时或者是创建一个参数化的类，比如下面的ThreadLocal。
     */
    public void f(){
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1); //autoboxing - primitive to object
        intList.add(2); //autoboxing

        ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>();
        intLocal.set(4); //autoboxing

        int number = intList.get(0); // unboxing
        int local = intLocal.get(); // unboxing in Java
    }

    /**
     * 自动装箱主要发生在两种情况，一种是赋值时，另一种是在方法调用的时候。
     * 赋值时
     * 这是最常见的一种情况，在Java 1.5以前我们需要手动地进行转换才行，而现在所有的转换都是由编译器来完成。
     */
    public void f1(){
        //before autoboxing
        Integer iObject = Integer.valueOf(3); //手动转换
        int iPrimitive = iObject.intValue();

       //after java5
        Integer iObject2 = 3; //autobxing - primitive to wrapper conversion
        int iPrimitive2 = iObject; //unboxing - object to primitive conversion
    }

    /**
     * 方法调用时
     * 这是另一个常用的情况，当我们在方法调用时，我们可以传入原始数据值或者对象，同样编译器会帮我们进行转换。
     *
     * show方法接受Integer对象作为参数，当调用show(3)时，会将int值转换成对应的Integer对象，这就是所谓的自动装箱，
     * show方法返回Integer对象，而int result = show(3);中result为int类型，所以这时候发生自动拆箱操作，
     * 将show方法的返回的Integer对象转换成int值。
     */
    public static Integer show(Integer iParam){
        System.out.println("autoboxing example - method invocation i: " + iParam);
        return iParam;
    }

    /**
     * 自动装箱的弊端
     * 自动装箱有一个问题，那就是在一个循环中进行自动装箱操作的情况，如下面的例子就会创建多余的对象，影响程序的性能。
     *
     * 上面的代码sum+=i可以看成sum = sum + i，但是+这个操作符不适用于Integer对象，首先sum进行自动拆箱操作，进行数值相加操作，
     * 最后发生自动装箱操作转换成Integer对象。其内部变化如下:
     * int result = sum.intValue() + i;
     * Integer sum = new Integer(result);
     *
     * 由于我们这里声明的sum为Integer类型，在上面的循环中会创建将近4000个无用的Integer对象，在这样庞大的循环中，会降低程序的性能并且加重了垃圾回收的工作量。
     * 因此在我们编程时，需要注意到这一点，正确地声明变量类型，避免因为自动装箱引起的性能问题。
     */
    public void f3(){
        Integer sum = 0;
        for(int i=1000; i<5000; i++){
            sum+=i;
        }
    }

    /**
     * 重载与自动装箱
     *
     * 当重载遇上自动装箱时，情况会比较有些复杂，可能会让人产生有些困惑。在1.5之前，value(int)和value(Integer)是完全不相同的方法，
     * 开发者不会因为传入是int还是Integer调用哪个方法困惑，但是由于自动装箱和拆箱的引入，处理重载方法时稍微有点复杂。一个典型的例子就是ArrayList的remove方法，
     * 它有remove(index)和remove(Object)两种重载，我们可能会有一点小小的困惑，
     * 其实这种困惑是可以验证并解开的，通过下面的例子我们可以看到，当出现这种情况时，不会发生自动装箱操作
     */
    public void test(int num){
        System.out.println("method with primitive argument");

    }

    public void test(Integer num){
        System.out.println("method with wrapper argument");

    }

    /**
     * 对象相等比较
     * 这是一个比较容易出错的地方，”==“可以用于原始值进行比较，也可以用于对象进行比较，当用于对象与对象之间比较时，
     * 比较的不是对象代表的值，而是检查两个对象是否是同一对象，这个比较过程中没有自动装箱发生。进行对象值比较不应该使用”==“，
     * 而应该使用对象对应的equals方法。
     *
     * 值得注意的是第三个小例子，这是一种极端情况。obj1和obj2的初始化都发生了自动装箱操作。但是处于节省内存的考虑，JVM会缓存-128到127的Integer对象。
     * 因为obj1和obj2实际上是同一个对象。所以使用”==“比较返回true。
     */
    public void f4(){
        // Example 1: == comparison pure primitive – no autoboxing
        int i1 = 1;
        int i2 = 1;
        System.out.println("i1==i2 : " + (i1 == i2)); // true

        // Example 2: equality operator mixing object and primitive
        Integer num1 = 1; // autoboxing
        int num2 = 1;
        System.out.println("num1 == num2 : " + (num1 == num2)); // true

        // Example 3: special case - arises due to autoboxing in Java
        Integer obj1 = 1; // autoboxing will call Integer.valueOf()
        Integer obj2 = 1; // same call to Integer.valueOf() will return same
        // cached Object 缓存对象

        System.out.println("obj1 == obj2 : " + (obj1 == obj2)); // true

        Integer obj3 = 128;
        Integer obj4 = 128;
        System.out.println("obj3 == obj4 : " + (obj3 == obj4)); //false
        //no cached Object 没有做缓存对象处理


        // Example 4: equality operator - pure object comparison
        Integer one = new Integer(1); // no autoboxing
        Integer anotherOne = new Integer(1);
        System.out.println("one == anotherOne : " + (one == anotherOne)); // false
    }

    /**
     *容易混乱的对象和原始数据值
     * 另一个需要避免的问题就是混乱使用对象和原始数据值，一个具体的例子就是当我们在一个原始数据值与一个对象进行比较时，如果这个对象没有进行初始化或者为Null，
     * 在自动拆箱过程中obj.xxxValue，会抛出NullPointerException,如下面的代码
     *
     * private static Integer count;
     *
     * //NullPointerException on unboxing
     * if( count <= 0){
     *   System.out.println("Count is not started yet");
     * }
     */

    /**
     * 缓存的对象
     * 这个问题就是我们上面提到的极端情况，在Java中，会对-128到127的Integer对象进行缓存，当创建新的Integer对象时，如果符合这个这个范围，
     * 并且已有存在的相同值的对象，则返回这个对象，否则创建新的Integer对象。
     *
     * 在Java中另一个节省内存的例子就是字符串常量池,感兴趣的同学可以了解一下。
     */

    /**
     生成无用对象增加GC压力
     因为自动装箱会隐式地创建对象，像前面提到的那样，如果在一个循环体中，会创建无用的中间对象，这样会增加GC压力，
     拉低程序的性能。所以在写循环时一定要注意代码，避免引入不必要的自动装箱操作。
     */

    public static void main(String[] args) {
        //autoboxing and unboxing in method invocation
        show(3); //autoboxing
        int result = show(3); //unboxing because return type of method is Integer


        Demo demo=new Demo();
        int value=3;
        demo.test(value); //no autoboxing  //输出结果 method with primitive argument
        Integer ivalue = value;
        demo.test(ivalue); //no autoboxing  //输出结果 method with wrapper argument
    }
}

