package com.datastructure.learning.leetcode.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 方法三：递归四行代码实现解题
 * 课后习题：建议同学们对链表的增删该查，使用递归来实现
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        //替换上面的几行逻辑  TODO 理解这两行代码
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    //测试
    public static void main(String[] args) {
        int [] nums={1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution3().removeElements(head, 6);
        System.out.println(res);
    }

}
