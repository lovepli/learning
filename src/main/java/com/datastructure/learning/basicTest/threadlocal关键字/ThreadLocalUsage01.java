package com.datastructure.learning.basicTest.threadlocal关键字;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description:
 * 假如我们有一个需求，那就是在多线程环境下，去格式化时间为指定格式yyyy-MM-dd HH:mm:ss，假设一开始只有两个线程需要这么做，代码如下：
 */
public class ThreadLocalUsage01 {

    private String date(int seconds){
        // 参数的单位是毫秒，从1970.1.1 00:00:00 GMT计时
        Date date=new Date(1000*seconds);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm;ss");
        return dateFormat.format(date);
    }

  public static void main(String[] args) {

      new Thread(new Runnable() {
          @Override
          public void run() {
              String date=new ThreadLocalUsage01().date(10);
              System.out.println(date);
          }
      }).start();

      new Thread(new Runnable() {
          @Override
          public void run() {
              String date =new ThreadLocalUsage01().date(100);
              System.out.println(date);
          }
      }).start();
    //
  }


}
