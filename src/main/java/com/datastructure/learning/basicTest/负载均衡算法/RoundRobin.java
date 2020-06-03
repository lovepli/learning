package com.datastructure.learning.basicTest.负载均衡算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/6/1 参考：https://mp.weixin.qq.com/s/6ei9QLyp1SRe6gXlFPXD2w
 * @description: 轮询算法： 将接收到的请求依次转发到后端服务器上，它均衡对待（一视同仁）所有服务器，而不关心当前服务器实际连接数及当前系统负载。 这里实现一个简单的轮询系统：
 *     在实际生产环境中，我们还得考虑诸多因素，比如：
 *     <p>新增服务器ip如何处理？ 这个比较简单，直接添加到initServerList()即可。
 *     <p>出现服务宕机怎么办？ 比如192.168.10.01
 *     所在服务器挂掉了，请求被转发给它，就会报错。这时，需要服务的消费者考虑容错处理，在这种情况下，比如再发一次请求，那就会被转发到192.168.10.02 机器上，正常。
 *     该方法最大缺点是引用了悲观锁 synchronized，影响系统的并发性能。
 *     <p>每台机器的配置不一样，有单核CPU，2G内存，有8核CPU，32G内存。这种情形下，使用上述轮询，那就不公平了，对弱配置机器，压力很大。 这个，我们可以引入加权轮询
 */
public class RoundRobin {

  static Integer position = 0;

  public static List<String> initServerList() {
    List<String> servers = new ArrayList<>();
    servers.add("192.168.10.00");
    servers.add("192.168.10.01");
    servers.add("192.168.10.02");
    servers.add("192.168.10.03");
    servers.add("192.168.10.04");
    servers.add("192.168.10.05");
    servers.add("192.168.10.06");
    return servers;
  }

  public static String getServerUrl() {
    // 新建立一个List赋值，避免服务器上下线导致的并发问题
    List<String> serverList = new ArrayList<>();
    serverList.addAll(initServerList());

    String server = null;
    synchronized (position) {
      if (position >= serverList.size()) {
        position = 0;
      }
      server = serverList.get(position);
      position++;
    }
    return server;
  }

  public static void main(String[] args) throws InterruptedException {
    //
    while (true) {
      Thread.sleep(3000);
      System.out.println(getServerUrl());
    }
  }
}
