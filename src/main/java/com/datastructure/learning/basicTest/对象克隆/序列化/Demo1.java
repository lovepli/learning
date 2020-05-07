package com.datastructure.learning.basicTest.对象克隆.序列化;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:
 */
public class Demo1 {

    /**
     *什么是 java 序列化，如何实现 java 序列化？
     *
     * 序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读
     * 写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。
     * 序 列 化 的 实 现 ： 将 需 要 被 序 列 化 的 类 实 现 Serializable 接 口 ， 该 接 口 没 有 需 要 实 现 的 方 法 ，
     * implements Serializable 只是为了标注该对象是可被序列化的，然后使用一个输出流(如： FileOutputStream)来构造
     * 一个 ObjectOutputStream(对象流)对象，接着，使用 ObjectOutputStream 对象的 writeObject(Object obj)方法就
     * 可以将参数为 obj 的对象写出(即保存其状态)，要恢复的话则用输入流。
     */
}
