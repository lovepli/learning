package com.datastructure.learning.basicTest.final关键字.最佳实践;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:  方法二
 */
public class ThreadLocalDemo2 {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //第一次调用get将返回null
    private static ThreadLocal threadLocal = new ThreadLocal();

    //获取线程的变量副本，如果不覆盖initialValue，第一次get返回null，故需要初始化一个SimpleDateFormat，并set到threadLocal中
    public static DateFormat getDateFormat() {
        DateFormat df = (DateFormat) threadLocal.get();
        if(df==null){
            df = new SimpleDateFormat(DATE_FORMAT);
            threadLocal.set(df);
        }
        return df;
    }
//通过以上方式,每个线程会实例化一个SimpleDateFormat实例，实例在线程内共享，达到了解决线程安全性的问题，一定程度上也提高了性能。
}
