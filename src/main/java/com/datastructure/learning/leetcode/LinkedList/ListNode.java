package com.datastructure.learning.leetcode.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description:
 */
public class ListNode {
  int val;
  ListNode next;

  /** 构造函数 */
  public ListNode(int x) {
    val = x;
  }

    /**
     * 链表节点的构造函数 将数组转换成链表
     * 使用arr 数组为参数，创建一个链表，当前的ListNode为链表头节点
     * @param arr
     */
  public ListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("arr can not be empty.");
    }
    // TODO 理解下面的几行的意思！！！！
    this.val = arr[0]; // 当前对象的var值
    ListNode cur = this; // 新建一个ListNode cur指向当前ListNode对象 cur即为链表头节点

    for (int i = 1; i < arr.length; i++) {
      cur.next =
          new ListNode(arr[i]); // 这里调用ListNode(int x)构造函数构造ListNode对象，cur.next指向这个新建的ListNode对象
      cur = cur.next; // cur 当前ListNode对象指向cur.next对象
    }
  }

  /**
   * 以当前节点为头节点的链表信息的字符串
   * @return
   */
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    ListNode cur = this; // cur即为链表头节点 因为cur 指向this
    while (cur != null) {
      res.append(cur.val + "->"); // 拼接元素
      cur = cur.next; // 当前节点指向下一个节点
    }
    res.append("NULL");
    return res.toString();
  }
}
