package com.datastructure.learning.basicTest.集合.demo4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description:  Map 中的 key 和 value 可以为 null 么？
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();//HashMap 对象
        Map<String, String> tableMap = new Hashtable<String, String>();//HashTable 对象

        map.put(null, null);
        System.out.println("hashMap 的[key]和[value]均可以为 null:" + map.get(null));

        try {
            tableMap.put(null, "3");
            System.out.println(tableMap.get(null));
        } catch (Exception e) {
            System.out.println("【ERROR】： hashTable 的[key]不能为 null");
        }

        try {
            tableMap.put("3", null);

            System.out.println(tableMap.get("3"));
        } catch (Exception e) {
            System.out.println("【ERROR】： hashTable 的[value]不能为 null");
        }
    }

}


/**
 * Map 中的 key 和 value 可以为 null 么？
 * HashMap 对象的 key、 value 值均可为 null。
 * HahTable 对象的 key、 value 值均不可为 null。
 * 且两者的的 key 值均不能重复，若添加 key 相同的键值对，后面的 value 会自动覆盖前面的 value，但不会报错。
 */

