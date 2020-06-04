package com.datastructure.learning.datastucture.LinkedList;

/**
 * @author: lipan
 * @date: 2019-05-27
 * @description:
 */
public class LinkListTest {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList =new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);  //一直向链表的头部添加节点
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

    }
}
