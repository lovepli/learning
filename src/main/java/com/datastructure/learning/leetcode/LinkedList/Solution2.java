package com.datastructure.learning.leetcode.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 使用虚拟头节点 统一头节点和其他节点的代码逻辑，简化代码
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1); //创建一个虚拟头节点，随便给一个值
        dummyHead.next = head;  //将虚拟头节点指向head节点

        ListNode prev =dummyHead; //从虚拟头节点开始
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;//返回删除指定元素之后的链表 这里因为有一个头节点，所有最后返回的节点不包含头节点
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
