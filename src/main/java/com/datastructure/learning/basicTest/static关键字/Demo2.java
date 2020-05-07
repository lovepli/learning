package com.datastructure.learning.basicTest.static关键字;

import org.apache.commons.logging.LogFactory;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:  减少对象的创建
 */
public class Demo2 {

    //第二种虽然场景不多，但是基本在每个工程里面都会使用到，比如声明Loggger变量：
   // private static final Logger LOGGER = LogFactory.getLoggger(Demo2.class);

    //实际上，如果把static去掉也是可行的，比如：
   // private final Logger LOGGER = LogFactory.getLoggger(Demo2.class);

    /**
     * 这样一来，对于每个MyClass的实例化对象都会拥有一个LOGGER，如果创建了1000个MyClass对象，则会多出1000个Logger对象，
     * 造成资源的浪费，因此通常会将Logger对象声明为static变量，这样一来，能够减少对内存资源的占用。
     */
}
