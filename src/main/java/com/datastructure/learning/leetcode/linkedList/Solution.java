package com.datastructure.learning.leetcode.linkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 删除链表中值为value的所有元素 203题
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {  //这里不用if判断，考虑到下一个节点可能也是val的情况，要循环判断
//            ListNode delNode =head;
//            head =head.next;
//            delNode.next = null;
            //一句话替换三句话
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev =head;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                //一句话替换三句话
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
//测试
    public static void main(String[] args) {
        int [] nums={1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution().removeElements(head, 6);
        System.out.println(res);
    }
}
