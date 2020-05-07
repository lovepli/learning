package com.datastructure.learning.basicTest.对象克隆;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class Demo {

    /**
     * 如何实现对象克隆？
     * 1). 实现 Cloneable 接口并重写 Object 类中的 clone()方法；
     * 2). 实现 Serializable 接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆.
     *
     *
     * 注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对
     * 象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用 Object 类的 clone
     * 方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。
     */


}
