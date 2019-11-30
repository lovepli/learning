package com.datastructure.learning.datastucture.SetAndMap.map;

import com.datastructure.learning.datastucture.SetAndMap.map.util.FileOperation;

import java.util.ArrayList;

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description:
 */
public class MapTest {

    private static void linkedListMapTest(){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            //map映射
            LinkedListMap<String, Integer> map = new LinkedListMap<>();  //key-String:单词 value-Integer:单词出现的频率 即词频
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();

    }

    private static void bstMapTest(){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            //map映射
            BSTMap<String, Integer> map = new BSTMap<>();  //key-String:单词 value-Integer:单词出现的频率 即词频
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Toltal words: " +words.size());
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1); //这一段
                } else {
                    map.add(word,1);
                }
            }

            System.out.println("Total different words: "+map.getSize());
            System.out.println("Frequency of PRIDE:"+map.get("pride"));
            System.out.println("Frequency of PRIEJUDICE:"+map.get("prejudice"));
        }

        long endTime =System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        //linkedListMapTest();

        //bstMapTest(); //执行的操作相比较链表要多一些


        String filename="pride-and-prejudice.txt";

        BSTMap<String,Integer> bstMap=new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: "+ time1 +"s");

        System.out.println();

        LinkedListMap<String,Integer> linkedListMap=new LinkedListMap<>();
        double time2=testMap(linkedListMap,filename);
        System.out.println("Linked List Map:"+time2+"s");


    }



}
