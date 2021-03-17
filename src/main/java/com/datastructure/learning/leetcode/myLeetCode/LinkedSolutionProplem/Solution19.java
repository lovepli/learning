package com.datastructure.learning.leetcode.myLeetCode.LinkedSolutionProplem;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 相关标签 链表 双指针
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution19 {
    //定义单链表，题目已经提供，不需要自己再写
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * 双指针。核心就是给头结点上面再加个头结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = new ListNode(0, head); //核心，给头结点上面再加个头结点
        ListNode slow = top, fast = head;
        for(int i = 1; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return top.next;
    }

    /**
     * 1，非递归解决
     * 这题让删除链表的倒数第n个节点，首先最容易想到的就是先求出链表的长度length，然后就可以找到要删除链表的前一个结点，
     * 让他的前一个结点指向要删除结点的下一个结点即可，这里就以示例为例画个图看一下
     *
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/?discussion=9Dqd9Q
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        //如果last等于0表示删除的是头结点
        if (last == 0)
            return head.next;
        //这里首先要找到要删除链表的前一个结点
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    //求链表的长度
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


    /**
     * 2，双指针求解
     * 上面是先计算链表的长度，其实不计算链表的长度也是可以，我们可以使用两个指针，一个指针fast先走n步，
     * 然后另一个指针slow从头结点开始，找到要删除结点的前一个结点，这样就可以完成结点的删除了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //fast移n步，
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 3，递归解决
     * 我们知道获取链表的长度除了上面介绍的一种方式以外，还可以写成递归的方式，比如
     *
     * //求链表的长度
     * private int length(ListNode head) {
     *     if (head == null)
     *         return 0;
     *     return length(head.next) + 1;
     * }
     * 上面计算链表长度的递归其实可以把它看做是从后往前计算，当计算的长度是n的时候就表示遍历到了倒数第n个节点了，
     * 这里只要求出倒数第n+1个节点，问题就迎刃而解了，来看下代码
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_3(ListNode head, int n) {
        int pos = length(head, n);
        // 说明删除的是头节点
        if (pos == n)
            return head.next;
        return head;
    }

    // 获取节点所在位置，逆序
    private int length(ListNode node, int n) {
        if (node == null)
            return 0;
        int pos = length(node.next, n) + 1;
        //获取要删除链表的前一个结点，就可以完成链表的删除
        if (pos == n + 1)
            node.next = node.next.next;
        return pos;
    }



}

