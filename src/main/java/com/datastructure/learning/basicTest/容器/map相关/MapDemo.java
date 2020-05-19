package com.datastructure.learning.basicTest.容器.map相关;

import org.springframework.context.ApplicationEventPublisher;

import java.util.*;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description: map的遍历方式
 */
public class MapDemo {

  /**
   * 方法一 在for-each循环中使用entries来遍历 注意：for-each循环在java 5中被引入所以该方法只能应用于java 5或更高的版本中。
   * 如果你遍历的是一个空的map对象，for-each循环将抛出NullPointerException，因此在遍历前你总是应该检查空引用。
   * 这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用
   */
  public static void fun() {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
  }

  /**
   * 方法二 在for-each循环中遍历keys或values。
   *
   * <p>如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。 该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
   */
  public static void fun2() {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // 遍历map中的键
    for (Integer key : map.keySet()) {

      System.out.println("Key = " + key);
    }

    // 遍历map中的值

    for (Integer value : map.values()) {

      System.out.println("Value = " + value);
    }
  }

  /**
   * 方法三使用Iterator遍历
   *
   * <p>使用泛型：
   */
  public static void fun3() {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();

    while (entries.hasNext()) {

      Map.Entry<Integer, Integer> entry = entries.next();

      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
  }

  /**
   * 不使用泛型：
   *
   * <p>你也可以在keySet和values上应用同样的方法。
   * 该种方式看起来冗余却有其优点所在。首先，在老版本java中这是惟一遍历map的方式。另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
   *
   * <p>从性能方面看，该方法类同于for-each遍历（即方法二）的性能。 ———————————————— 版权声明：本文为CSDN博主「Java高知社区」的原创文章，遵循CC 4.0
   * BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/tjcyjd/article/details/11111401
   */
  public static void fun33() {
    Map map = new HashMap();

    Iterator entries = map.entrySet().iterator();

    while (entries.hasNext()) {

      Map.Entry entry = (Map.Entry) entries.next();

      Integer key = (Integer) entry.getKey();

      Integer value = (Integer) entry.getValue();

      System.out.println("Key = " + key + ", Value = " + value);
    }
  }

  /**
   * 方法四、通过键找值遍历（效率低）
   *
   * <p>作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。
   * 如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。
   */
  public static void fun4() {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (Integer key : map.keySet()) {

      Integer value = map.get(key);

      System.out.println("Key = " + key + ", Value = " + value);
    }
  }

  /** lambda 表达式遍历map */
  public static void lambdaDemo1() {
    // ============Java8之前的方式==========
    Map<String, Integer> items = new HashMap<>();
    items.put("A", 10);
    items.put("B", 20);
    items.put("C", 30);
    items.put("D", 40);
    items.put("E", 50);
    items.put("F", 60);
    for (Map.Entry<String, Integer> entry : items.entrySet()) {
      System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
    }
    // ============forEach + Lambda表达式==========
    Map<String, Integer> items2 = new HashMap<>();
    items2.put("A", 10);
    items2.put("B", 20);
    items2.put("C", 30);
    items2.put("D", 40);
    items2.put("E", 50);
    items2.put("F", 60);
    items2.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
    items2.forEach(
        (k, v) -> {
          System.out.println("Item : " + k + " Count : " + v);
          if ("E".equals(k)) {
            System.out.println("Hello E");
          }
        });
  }

  /** lambda 遍历list */
  public static void lambdaDemo2() {
    // ============Java8之前的方式==========
    List<String> items = new ArrayList<>();
    items.add("A");
    items.add("B");
    items.add("C");
    items.add("D");
    items.add("E");

    for (String item : items) {
      System.out.println(item);
    }
    // ============forEach + Lambda表达式==========
    List<String> items2 = new ArrayList<>();
    items2.add("A");
    items2.add("B");
    items2.add("C");
    items2.add("D");
    items2.add("E");
    // 输出：A,B,C,D,E
    items2.forEach(item -> System.out.println(item));
    // 输出 : C
    items2.forEach(
        item -> {
          if ("C".equals(item)) {
            System.out.println(item);
          }
        });
  }

  /**
   * 总结
   *
   * <p>如果仅需要键(keys)或值(values)使用方法二。如果你使用的语言版本低于java 5， 或是打算在遍历时删除entries，必须使用方法三。否则使用方法一(键值都要)。
   */
  public static void main(String[] args) {
    //
  }
}
