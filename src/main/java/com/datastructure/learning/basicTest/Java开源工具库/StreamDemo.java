package com.datastructure.learning.basicTest.Java开源工具库;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description: Java 8 Stream Stream 不算是工具库，但是通过 stream 提供的一系列方法，可以实现集合的过滤、分组、集合转换等诸多操作。
 *     <p>例如下面的方法，实现列表元素根据某个字段去重的功能。
 */
public class StreamDemo {

  /**
   * List<User> userList = new ArrayList(); //添加元素 userList =
   * userList.stream().filter(distinctByKey(user->user.getUserId())).collect(Collectors.toList());
   *
   * private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
   * Map<Object,Boolean> seen = new ConcurrentHashMap<>(); return t ->
   * seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; }
   */
}
