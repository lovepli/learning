package com.datastructure.learning.basicTest.threadlocal关键字;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description:
 */
public class ThreadLocalUsage04 {
    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000; i++) {
            int finalI = i;
            THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalUsage04().date(finalI);
                    System.out.println(date);
                }
            });
        }
        THREAD_POOL.shutdown();
    }

    private String date(int seconds) {
        // 参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeDateFormatter.dateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }

}

class ThreadSafeDateFormatter {
    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);
    static SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal <SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

  // 上面的代码使用到了ThreadLocal，将SimpleDateFormat对象用ThreadLocal包装了一层，使得多个线程内部都有一个SimpleDateFormat对象副本，每个线程使用自己的SimpleDateFormat，这样就不会产生线程安全问题了。
  //
  // 那么以上介绍的是ThreadLocal的第一大场景的使用，也就是利用到了ThreadLocal的initialValue()方法，使得每个线程内都具备了一个SimpleDateFormat副本。

}
