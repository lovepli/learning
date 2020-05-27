package com.datastructure.learning.basicTest.threadlocal关键字;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description:
 *     在线程少的情况下是没有问题的，我们在每个线程里调用date方法，也就是在每个线程里都执行了创建SimpleDateFormat对象，每个对象在各自的线程里面执行格式化时间
 *     <p>但是我们是否会思考到，假如有1000个线程需要格式化时间，那么需要调用1000次date方法，也就是需要创建1000个作用一样的SimpleDateFormat对象，这样是不是太浪费内存了？也给GC带来压力？
 *     <p>于是我们联想到，1000个线程来共享一个SimpleDateFormat对象，这样SimpleDateFormat对象只需要创建一次即可，代码如下：
 */
public class ThreadLocalUsage02 {
    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);
    static SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String date(int seconds){
        // 参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date=new Date(1000*seconds);
        return DATE_FORMAT.format(date);
    }

  public static void main(String[] args) {
      for (int i=0;i<1000;i++){
          int finalI =i;
          THREAD_POOL.submit(new Runnable() {
              @Override
              public void run() {
                  String date=new ThreadLocalUsage02().date(finalI);
                  System.out.println(date);
              }
          });
          // 关闭线程池，此种关闭方式不再接受新的任务提交，等待现有队列中的任务全部执行完毕之后关闭
          THREAD_POOL.shutdown();
      }
    //上述代码我们使用到了固定线程数的线程池来执行时间格式化任务，我们来执行一下，看看结果：
//      现执行结果中有很多重复的时间格式化内容，这是为什么呢？
//
//      这是因为SimpleDateFormat是一个线程不安全的类，其实例对象在多线程环境下作为共享数据，会发生线程不安全问题。
      //说到这里，很多读者肯定会说，我们可以尝试一下使用锁机制，我们将date方法内的格式化代码使用synchronized关键字概括起来，保证同一时刻只能有一个线程来访问SimpleDateFormat的format方法，代码如下所示：
  }

  //使用锁机制，同步代码块
  private String date2(int seconds){
        Date date =new Date(1000*seconds);
        String format;
        synchronized (ThreadLocalUsage02.class){
            format=DATE_FORMAT.format(date);
        }
        return format;
  }

  // 有了锁的保证，那么这次执行后就不会再出现重复的时间格式化结果了，这也就保证了线程安全。
  //
  // 使用锁机制确实可以解决问题，但是多数情况下，我们不大愿意使用锁，因为锁的使用会带来性能的下降（比如10个线程重复排队执行DATE_FORMAT.format(date)代码），那么有没有其他方法来解决这个问题呢？答案当然是有，那就是本文的主角——ThreadLocal。
}
