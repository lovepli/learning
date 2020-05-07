package com.datastructure.learning.basicTest.final关键字.最佳实践;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:  典型例子
 * 对于线程不安全的SimpleDataFormat对象，如果在线程池中使用并声明为ThreadLocal类型，可以有效的减少其对象数量，同事保持线程安全。
 */
public class ThreadLocalDemo { //使用ThreadLocal以空间换时间解决SimpleDateFormat线程安全问题

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 创建一个ThreadLocal类变量，这里创建时用了一个匿名类，覆盖了initialValue方法，主要作用是创建时初始化实例
     */
    private static ThreadLocal threadLocal = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };

    public static DateFormat getDateFormat() {
        return (DateFormat) threadLocal.get();
    }

    public static Date parse(String textDate) throws ParseException {
        return getDateFormat().parse(textDate);
    }

}
