package com.datastructure.learning.basicTest.Java开源工具库;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description: Google Guava 官方地址：https://github.com/google/guava 和 Apache Commons
 *     有点儿类似，它也是包含了一系列的比如字符串、集合、反射、数学计算等的操作封装，还可以用作 JVM 缓存。
 */
public class GuavaDemo {

  /**
   * 举几个例子说明：
   *
   * New 各种对象
   * List<String> list = Lists.newArrayList(); Set<String> set = Sets.newHashSet();
   * Map<String,Object> map = Maps.newConcurrentMap();
   *
   * // 不可变集合 ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3");
   *
   * 列表转符号分隔的字符串
   * List<String> list = new ArrayList<String>(); list.add("1"); list.add("2"); list.add("3");
   * String result = Joiner.on("-").join(list);
   *
   * > 1-2-3
   *
   * 求交集、并集、差集等 例如下面代码求 set1 和 set2 的交集
   * Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5, 6); Set<Integer> set2 =
   * Sets.newHashSet(1,2,3,4);
   *
   * Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
   */
}
