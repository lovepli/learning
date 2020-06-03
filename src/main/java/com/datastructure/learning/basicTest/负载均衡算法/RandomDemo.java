package com.datastructure.learning.basicTest.负载均衡算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: lipan
 * @date: 2020/6/1
 * @description: 随机算法
 *     顾名思义：现有N个服务器ip地址，请求来了后，随机转发到某个服务器上。从概率的角度来说，随着请求数的增多，最终每台服务器分配到的请求，近似于均等。这就比轮询算法少了个悲观锁，并发性能上，有了极大的提升。
 *     <p>实现也很简单：
 *
 *     <p>但他也有与简单轮询算法一样的问题：
 *     <p>对于不同性能的服务器，依旧一视同仁，那其实是不公平的。低配置，应该少分点请求嘛。
 *     <p>这就有了
 *
 *     延伸：加权随机算法，其实现思想同 加权轮询算法一样，给不同配置的服务器，配置不同的权重值。代码实现也同加权轮询思路一样，构建出符合权重值的服务集合后，再进行随机选取，这里就不写了，留给大家自己去写吧。
 */
public class RandomDemo {
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

        //新建立一个List赋值，避免服务器上下线导致的并发问题

        List<String> serverList = new ArrayList<>();

        serverList.addAll(initServerList());

        int position = new Random().nextInt(serverList.size());

        return serverList.get(position);

    }

    public static void main(String[] args) {

        while (true) {

            System.out.println(getServerUrl());

        }

    }
}
