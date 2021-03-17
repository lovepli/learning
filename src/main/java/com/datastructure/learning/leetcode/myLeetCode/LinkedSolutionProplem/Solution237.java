package com.datastructure.learning.leetcode.myLeetCode.LinkedSolutionProplem;
/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 * 现有一个链表 --head =[4,5,1,9]，它可以表示为:
 * 4 -> 5 -> 1 -> 9.
 *
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2：
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 提示：
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * 相关标签 链表
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/**
 * Definition for singly-linked list.单链表的定义
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution237 {
    //定义单链表，题目会提供
 class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
 }

    /**
     * 解题思路：
     * 目标：杀掉A
     * 正常杀手需要找到A的把柄才可以杀掉A，
     * 可现在找到A本人后竟然没有可以获取A把柄的途径
     * A得知我们要杀他，心生一计，可助你完成任务
     * A说我有B的把柄，你杀了B，我改头换面，以B的身份活着
     * GC也会自动清理掉B的尸体，没人会知道的
     */
    public void deleteNode_1(ListNode node) {
        //1、把要删除结点的下一个结点的值赋给要删除的结点
        node.val = node.next.val; // 替换元素
        //2、然后删除下一个结点
        node.next = node.next.next; // 替换引用地址
    }

    public static void main(String[] args) {

    }
}
