package com.datastructure.learning.datastucture.SetAndMap.set;

import com.datastructure.learning.datastucture.SetAndMap.set.util.FileOperation;

import java.util.ArrayList;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description:
 */
public class SetTest {

    /**
     * 使用BST二分搜索树这种数据结构来测试
     */
    private static void bstSetTest() {

        System.out.println("Pride and Prejudice"); //只打印输出了这一句

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {  //傲慢与偏见
            System.out.println("Total words: " + words1.size());  //没有输出来？？ 文件路径不正确

            BSTSet<String> set1 = new BSTSet<>(); //使用BST二分搜索树这种数据结构来测试
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){ //双城记
            System.out.println("Total words: " + words2.size());  //总共单词数，没有输出来？？

            BSTSet<String> set2 = new BSTSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize()); //总共不同的单词数，没有输出来？？
        }
    }

    /**
     * 使用linkedList链表这种数据结构来测试
     */
    private static void linkedListSetTest() {
        System.out.println("Pride and Prejudice"); //只打印输出了这一句

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {  //傲慢与偏见
            System.out.println("Total words: " + words1.size());  //没有输出来？？ 文件路径不正确

            LinkedListSet<String> set1 = new LinkedListSet<>();//使用linkedList链表这种数据结构来测试
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){ //双城记
            System.out.println("Total words: " + words2.size());  //总共单词数，没有输出来？？

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize()); //总共不同的单词数，没有输出来？？
        }
    }

    /**
     * 时间效率比较 分析时间复杂度
     * @param set
     * @param filename
     * @return
     */
    private static double testSet(Set<String> set,String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Toltal words: " +words.size());
            for (String word : words) {
                set.add(word);
                System.out.println("Total different words: "+set.getSize());
            }
        }

        long endTime =System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

      //  bstSetTest();

       // linkedListSetTest();  //时间明显较长

        String filename="pride-and-prejudice.txt";

        BSTSet<String> bstSet=new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: "+ time1 +"s");

        System.out.println();

        LinkedListSet<String> linkedListSet=new LinkedListSet<>();
        double time2=testSet(linkedListSet,filename);
        System.out.println("Linked List Set:"+time2+"s");


    }
}
