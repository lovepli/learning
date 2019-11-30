package com.datastructure.learning.leetcode.linkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description: 递归调试 打印输出来看递归的过程 也可以用debug
 */
public class Solution4 {

    public ListNode removeElements(ListNode head, int val,int depth) {  //depth:递归的深度

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Calll: remove "+ val +" in "+head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove "+ val + ": "+res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next =res;
            ret =head;
        }

        System.out.print(depthString);
        System.out.println("Return: "+ret);
        return ret;
    }


    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    //测试
    public static void main(String[] args) {
        int [] nums={1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution4().removeElements(head, 6,0);
        System.out.println(res);
    }

}
