package com.datastructure.learning.basicTest.集合.hashmapdemo;

import java.util.*;

/**
 * @author: lipan
 * @date: 2020-04-19
 * @description: HashMap 排序题，上机题
 *
 */
public class HashMapTest {

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 首先拿到 map 的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();

        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {

            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //按照要求根据 User 的 age 的倒序进行排
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        //创建一个新的有序的 HashMap 子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        //将 List 中的数据存储在 LinkedHashMap 中
        for(Map.Entry<Integer, User> entry : list){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
    //返回结果
        return linkedHashMap;
    }

    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
        /**
         * 控制台输出内容
         * {1=User [name=张三, age=25], 2=User [name=王五, age=28], 3=User [name=李四, age=22]}
         {2=User [name=王五, age=28], 1=User [name=张三, age=25], 3=User [name=李四, age=22]}
         */
    }
}


/**
 * 上机排序题目：
 * 已知一个 HashMap<Integer， User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对
 * HashMap 的排序功能，该方法接收 HashMap<Integer， User>为形参，返回类型为 HashMap<Integer， User>，
 * 要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
 *
 * 解题思路：
 * 注意：要做出这道题必须对集合的体系结构非常的熟悉。 HashMap 本身就是不可排序的，但是该道题偏偏让给
 * HashMap 排序，那我们就得想在 API 中有没有这样的 Map 结构是有序的， LinkedHashMap，对的，就是他，他是
 * Map 结构，也是链表结构，有序的，更可喜的是他是 HashMap 的子类，我们返回 LinkedHashMap<Integer,User>
 *即可，还符合面向接口（父类编程的思想）。
 * 但凡是对集合的操作，我们应该保持一个原则就是能用 JDK 中的 API 就有 JDK 中的 API，比如排序算法我们不应
 * 该去用冒泡或者选择，而是首先想到用 Collections 集合工具类。
 */


