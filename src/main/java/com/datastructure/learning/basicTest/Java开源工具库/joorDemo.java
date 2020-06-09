package com.datastructure.learning.basicTest.Java开源工具库;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description: 反射工具库 - jOOR 官方地址：https://github.com/jOOQ/jOOR 它是 JDK
 *     反射包的友好封装，通过一系列简单友好的链式操作实现反射调用。比如下面这个例子
 */
public class joorDemo {

  /**
   * public interface StringProxy { String substring(int beginIndex); }
   *
   * String substring = on("java.lang.String") .create("Hello World") .as(StringProxy.class).substring(6);
   * 简单的代码实现 JDK 动态代理，节省了不少代码。
   */
}
