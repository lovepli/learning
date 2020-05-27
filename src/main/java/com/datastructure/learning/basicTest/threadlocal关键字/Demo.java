package com.datastructure.learning.basicTest.threadlocal关键字;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description: 参考：https://mp.weixin.qq.com/s/0zuayo-EFQGFHhUGyGrYZw
 */
public class Demo {
  // ThreadLocal的二大使用场景，在使用之前，我们先把两个场景总结如下：
  //
  // 场景1：每个线程需要一个独享的对象，通常是工具类，比如典型的SimpleDateFormat和Random等。
  // 场景2：每个线程内需要保存线程内的全局变量，这样线程在执行多个方法的时候，可以在多个方法中获取这个线程内的全局变量，避免了过度参数传递的问题。

  // 总结例5和例6这两种threadlocal的用法，通常分别用在不同的场景里：
  //
  // 场景一：通常多线程之间需要拥有同一个对象的副本，那么通常就采用initialValue()方法进行初始化，直接将需要拥有的对象存储到ThreadLocal中。
  // 场景二：如果多个线程中存储不同的信息，为了方便在其他方法里面获取到信息，那么这种场景适合使用set()方法。例如，在拦截器生成的用户信息，用ThreadLocal.set直接放入到ThreadLocal中去，以便在后续的方法中取出来使用。
}
