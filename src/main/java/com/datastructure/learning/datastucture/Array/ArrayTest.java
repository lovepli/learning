package com.datastructure.learning.datastucture.Array;

/** 数组 */
public class ArrayTest {

  /** 数组的两种遍历方式 */
  private static void arrayTest1() {
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) arr[i] = i;

    int[] scores = new int[] {100, 99, 66};
    // 方式一
    for (int i = 0; i < scores.length; i++) System.out.println(scores[i]);

    // 方式二
    for (int score : scores) System.out.println(score);

    scores[0] = 98;
    for (int i = 0; i < scores.length; i++) System.out.println(scores[i]);
  }

  /** 向数组(动态)中添加删除元素 */
  private static void arrayTest2() {
    System.out.println();
    System.out.println("=================向数组添加元素=================");
    Array2 arr = new Array2(20);
    for (int i = 0; i < 10; i++) {
      arr.addLast(i);
    }
    System.out.println(arr);

    arr.add(1, 100);
    System.out.println(arr);

    arr.addFirsrt(-1);
    System.out.println(arr);
    System.out.println();

    System.out.println("=================删除数组里的元素=================");
    arr.remove(2);
    System.out.println(arr);

    arr.removeElement(4);
    System.out.println(arr);

    arr.removeFirst();
    System.out.println(arr);

    arr.addFirsrt(1);
    System.out.println(arr);
    // 返回数组中元素e所有索引组成的索引数组
    System.out.println(arr.find2(1));
    // 查找数组中元素e的个数
    System.out.println(arr.find3(1));

    // 删除数组中所有的元素e
    arr.remove3Element(1);
    System.out.println(arr);
    System.out.println();

    System.out.println("======================泛型数组添加元素 ======================");
    // 测试 新建一个存放int类型数据的数组对象
    Array2<Integer> earr = new Array2<>(20);
    for (int i = 0; i < 10; i++) {
      earr.addLast(i);
    }
    System.out.println(earr);

    earr.add(1, 100);
    System.out.println(earr);

    earr.addFirsrt(-1);
    System.out.println(earr);
    System.out.println();
  }

  /** Array数组的动态扩容和缩容 */
  private static void arrayTest3() {
    // 无参构造的数组默认容量为10
    Array2<Integer> earr = new Array2<>();

    for (int i = 0; i < 10; i++) {
      earr.addLast(i);
    }
    System.out.println(earr);
    // 添加一个就超出数组容量
    earr.add(1, 100);
    System.out.println(earr);

    earr.addFirsrt(-1);
    System.out.println(earr);
    System.out.println();

    // 删除容器元素，最后进行缩容
    earr.remove(2);
    System.out.println(earr);

    earr.removeElement(4);
    System.out.println(earr);

    earr.removeFirst();
    System.out.println(earr);
  }

  public static void main(String[] args) {

    //        arrayTest1();
    //
    //        arrayTest2();
    //
    //        arrayTest3();
  }
}
