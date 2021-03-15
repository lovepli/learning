package com.datastructure.learning.leetcode.myLeetCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: 59688
 * @date: 2021/3/15
 * @description:
 */
public class TodoMapLearn {

    /**
     * TODO 补充知识点:HashMap的 getOrDefault() 方法
     * getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
     * getOrDefault() 方法的语法为：
     * hashmap.get(Object key, V defaultValue)
     * 注：hashmap 是 HashMap 类的一个对象。
     *
     * 参数说明：
     * key - 键
     * defaultValue - 当指定的key并不存在映射关系中，则返回的该默认值
     * 返回值
     * 返回 key 相映射的的 value，如果给定的 key 在映射关系中找不到，则返回指定的默认值。
     */
    public void test(){
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // key 的映射存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value1 = sites.getOrDefault(1, "Not Found");
        System.out.println("Value for key 1:  " + value1); //输出结果：Value for key 1:  Google

        // key 的映射不存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value2 = sites.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2); //输出结果：Value for key 4:  Not Found
    }

    /**
     * TODO 扩展知识点：
     *  * 遍历Map的三种方式
     *  * 1:遍历所有的key
     *  * 2:遍历所有的键值树(key-value)
     *  * 3:遍历所有的value(不常用)
     */
    public void  MapDemo(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        //     ( k   , v )
        map.put("语文", 90);
        map.put("数学", 98);
        map.put("物理", 85);
        map.put("化学", 78);
        map.put("英语", 92);
        map.put("体育", 65);
        map.put("体育", 78);

        /*
         * 遍历所有的key
         * Set<K> keySet()
         * 该方法可以获取Map中所有的key，并将它们存入
         * 一个Set集合中返回
         * 所以，遍历该集合就等于遍历所有的key了
         */
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            System.out.println("key:"+key);
        }
        /*
         * 遍历键值树
         * Set<Entry> entrySet()
         * 该方法会将每一组key-value存入一个Entry
         * 实例中，并将这些Entry实例存入一个Set集合
         * 并返回
         * 我们只需要遍历该集合，拿到每一个Entry实例
         * 并获取其中的key与value即可
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> e:entrySet) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
         * 遍历所有的value
         */

        Collection<Integer> values = map.values();
        for(Integer value : values) {
            System.out.println("value:"+value);
        }

    }


}
