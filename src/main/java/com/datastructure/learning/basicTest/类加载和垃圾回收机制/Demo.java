package com.datastructure.learning.basicTest.类加载和垃圾回收机制;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class Demo {
}


/**
 * 理论上来讲 Sun 公司只定义了垃圾回收机制规则而不局限于其实现算法，因此不同厂商生产的虚拟机采用的算法
 * 也不尽相同。
 * GC（Garbage Collector）在回收对象前首先必须发现那些无用的对象，如何去发现定位这些无用的对象？常用
 * 的搜索算法如下：（即面试题：Java 的 GC 什么时候回收垃圾？）
 * 1、引用计数器算法(废弃)  //缺点：无法解决对象之间的循环引用的问题
 * 2、根搜索算法（使用）【可达性分析(Reachability Analysis)】
 *
 *
 * 引用计数器算法解释
 * 对一个对象添加引用计数器。每当有地方引用它时，计数器值加 1；当引用失效时，计
 * 数器值减 1.而当计数器的值为 0 时这个对象就不会再被使用，判断为已死。
 *
 * 可达性分析(Reachability Analysis)说明
 * 所有生成的对象都是一个称为"GC Roots"的根的子树。从 GC Roots 开始向下搜索，搜索所经过的路径称为引用链
 * (Reference Chain)，当一个对象到 GC Roots 没有任何引用链可以到达时，就称这个对象是不可达的（不可引用的），
 * 也就是可以被 GC 回收了。
 *
 * 对象之间的循环引用解释
 * 比如对象 A 中有一个字段指向了对象 B，而对象 B 中
 * 也有一个字段指向了对象 A，而事实上他们俩都不再使用，但计数器的值永远都不可能为 0，也就不会被回收，然后就
 * 发生了内存泄露
 *
 */

/**
 * 通过上面的算法搜索到无用对象之后，就是回收过程， 回收算法如下：
 * 1） 标记—清除算法（Mark-Sweep）（DVM 使用的算法）
 * 2） 复制算法（Copying）
 * 3） 标记—整理算法（Mark-Compact）
 * 4） 分代收集（Generational Collection）
 */

/**
 * Java GC 什么时候回收垃圾？
 * 总结分析
 * 对于堆中的对象，主要用可达性分析判断一个对象是否还存在引用，如果该对象没有任何引用就应该被回收。而
 * 根据我们实际对引用的不同需求，又分成了 4 中引用，每种引用的回收机制也是不同的。
 * 对于方法区中的常量和类，当一个常量没有任何对象引用它，它就可以被回收了。而对于类，如果可以判定它为无
 * 用类，就可以被回收了。
 */

/**
 * 对象的引用分类：
 * 无论是引用计数器还是可达性分析，判定对象是否存活都与引用有关！那么，如何定义对象的引用呢？
 * 我们希望给出这样一类描述：当内存空间还够时，能够保存在内存中；如果进行了垃圾回收之后内存空间仍旧非
 * 常紧张，则可以抛弃这些对象。所以根据不同的需求，给出如下四种引用，根据引用类型的不同， GC 回收时也会有不
 * 同的操作：
 * 1)强引用(Strong Reference):Object obj = new Object();只要强引用还存在， GC 永远不会回收掉被引用的对象
 * 2)软引用(Soft Reference)：描述一些还有用但非必需的对象。在系统将会发生内存溢出之前，会把这些对象列入
 * 回收范围进行二次回收（即系统将会发生内存溢出了，才会对他们进行回收。）
 * 3)弱引用(Weak Reference):程度比软引用还要弱一些。这些对象只能生存到下次 GC 之前。当 GC 工作时，无论内
 * 存是否足够都会将其回收（即只要进行 GC，就会对他们进行回收。）
 * 4)虚引用(Phantom Reference):一个对象是否存在虚引用，完全不会对其生存时间构成影响。
 */
