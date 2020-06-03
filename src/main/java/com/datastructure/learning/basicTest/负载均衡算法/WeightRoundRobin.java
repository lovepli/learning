package com.datastructure.learning.basicTest.负载均衡算法;

import java.util.*;

/**
 * @author: lipan
 * @date: 2020/6/1
 * @description: 加权轮询： 每台服务器，给一个权重值，权值高的，多分配点儿请求，权值少的，少分配点儿请求，。 实现思路也很简单，根据权值，重新构建服务列表，然后再轮询。上个图示：
 */
public class WeightRoundRobin {

  static Integer position = 0;

  public static Map<String, Integer> initServicesMap() {
    Map<String, Integer> servicesMap = new HashMap<>();
    servicesMap.put("192.168.10.00", 1);
    servicesMap.put("192.168.10.02", 3);
    servicesMap.put("192.168.10.03", 3);
    servicesMap.put("192.168.10.04", 5);
    servicesMap.put("192.168.10.05", 5);
    servicesMap.put("192.168.10.06", 5);
    return servicesMap;
  }

  public static String getServerUrl() {

    // 新建立一个List赋值，避免服务器上下线导致的并发问题

    Map<String, Integer> initMap = new HashMap<>();

    initMap = initServicesMap();

    Set<String> servicesSet = new HashSet<>();

    servicesSet.addAll(initMap.keySet());

    Iterator<String> servicesIterator = servicesSet.iterator();

    List<String> servicesList = new ArrayList<>();

    while (servicesIterator.hasNext()) {

      String server = servicesIterator.next();

      Integer weight = initMap.get(server);

      if (weight > 0) {

        for (int i = 0; i < weight; i++) {

          servicesList.add(server);
        }
      }
    }

    String server = null;

    synchronized (position) {
      if (position >= servicesList.size()) {

        position = 0;
      }

      server = servicesList.get(position);

      position++;
    }

    return server;
  }

  public static void main(String[] args) {

    while (true) {

      System.out.println(getServerUrl());
    }
  }
}
