package com.datastructure.learning.basicTest.负载均衡;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/6/1
 * @description: 源地址哈希（hashCode）法 ： 根据客户端的请求ip，通过哈希计算，得到一个数值，随后与服务器列表个数，进行取模计算，得到该请求
 *     访问服务器列表的序号。该方法，有个好处是，当服务器列表不变时，某个客户端，会始终访问某一个固定的服务器，这样就可以构建一个客户端--服务器之间，有状态的session。
 */
public class HashDemo {

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

    int requestIpHashCode = "192.168.10.06.109".hashCode();

    int position = requestIpHashCode % serverList.size();

    return serverList.get(position);
  }

  public static void main(String[] args) {

    while (true) {

      System.out.println(getServerUrl());
    }
  }
}
