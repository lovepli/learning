package com.datastructure.learning.datastucture.Trie;

import com.datastructure.learning.datastucture.SetAndMap.set.BSTSet;
import com.datastructure.learning.datastucture.SetAndMap.set.util.FileOperation;

import java.util.ArrayList;

/**
 * @author: lipan
 * @date: 2019-06-03
 * @description:  测试比较BSTSet和Tire的时间效率  结果Tire新能更强，时间更短
 */
public class TireTest {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for(String word: words)
                set.add(word);

            for(String word: words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
