package com.datastructure.learning.basicTest.codeTest;

import java.util.*;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:  例子：nagix的轮训方式之一：随机分配IP地址
 */
public class Demo1 {

    private static Map<String, Integer> serviceWeightMap = new HashMap<String, Integer>();  //作为存储的容器使用

    static {
        serviceWeightMap.put("192.168.1.100",1);
        serviceWeightMap.put("192.168.1.101",1);
        serviceWeightMap.put("192.168.1.102",4);
        serviceWeightMap.put("192.168.1.103",1);
        serviceWeightMap.put("192.168.1.103",1);//添加一个重复的值
    }

    public static String testRandom(){

        // 重新创建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serviceWeightMap);

        //取得IP地址list
        Set<String> keySet = serverMap.keySet();  //去重
        for (String s:keySet){
            System.out.println(s);
        }
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        for (String ss:keyList){
            System.out.println("---"+ss);
        }

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());

        String server = keyList.get(randomPos);

        return server;
    }

    public static void main(String[] args) {
        testRandom();
    }
}
