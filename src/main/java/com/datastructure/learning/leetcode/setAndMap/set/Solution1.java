package com.datastructure.learning.leetcode.setAndMap.set;

import java.util.TreeSet; //引入Java API中的集合 底层树平衡二叉树实现的

/**
 * @author: lipan
 * @date: 2019-05-29
 * @description: 第802题 关于set集合
 */
public class Solution1 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);

            set.add(res.toString());
        }

        return set.size();
    }
}
