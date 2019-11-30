package com.datastructure.learning.leetcode.linkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 使用虚拟头节点 统一头节点和其他节点的代码逻辑，简化代码
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1); //虚拟头节点随便给一个值
        dummyHead.next = head;

        ListNode prev =dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;//这一句什么意思？
    }

    //测试
    public static void main(String[] args) {
        int [] nums={1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution2().removeElements(head, 6);
        System.out.println(res);
    }
}
