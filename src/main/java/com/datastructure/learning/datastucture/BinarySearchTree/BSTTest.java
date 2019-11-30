package com.datastructure.learning.datastucture.BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: lipan
 * @date: 2019-05-28
 * @description:
 */
public class BSTTest {

    /**
     * 二分搜索树的几种遍历方式
     */
    private static void bSTTest1() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums){
            bst.add(num);
        }

        //前序遍历
        // bst.preOrder();
        //System.out.println();

        //非递归的前序遍历
        //bst.preOrderNR();
        //System.out.println();

        //层序遍历
        // bst.levelOrder();
        //System.out.println();

        //中序遍历
        // bst.inOrder();
        // System.out.println();

        //后序遍历 应用场景：内存的释放
        // bst.postOrder();
        //System.out.println();


        //打印输出二叉树
        //  System.out.println(bst);
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////


    }


    /**
     * 删除二分搜索树中的最大元素和最小元素
     */
    private static void bSTTest2() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n=1000;
        //test removeMin
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums =new ArrayList<>( );
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");

        //test removeMax
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

         nums =new ArrayList<>( );
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed");
    }

    public static void main(String[] args) {

        //遍历
        bSTTest1();

        //测试删除二分搜索树中的最大元素和最小元素
        bSTTest2();
    }




}
