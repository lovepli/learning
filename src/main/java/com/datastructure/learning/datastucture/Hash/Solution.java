package com.datastructure.learning.datastucture.Hash;

class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26]; //频率值数组 26个字符  使每一个字符都和一个索引相对应 字符转化成索引来操作
        for(int i = 0 ; i < s.length() ; i ++)
            freq[s.charAt(i) - 'a'] ++;  //阿斯克码？？加减

        for(int i = 0 ; i < s.length() ; i ++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
