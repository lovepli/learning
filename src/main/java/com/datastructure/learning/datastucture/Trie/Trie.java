package com.datastructure.learning.datastucture.Trie;

import java.util.TreeMap;  //这里我们引入标准库中的TreeMap 性能更高。也可以使用我们自己的BST

/**
 * @author: lipan
 * @date: 2019-06-03
 * @description:  Trie 是一个多叉树，区别二叉树  字典树(前缀树)：首先是一个树结构，然后存储的是一个一个的字符串，合成起来就像一个字典
 * 典型案例：使用Tire创建一个通讯录
 * Tire的局限性：最大的问题：空间！ 使用压缩字典树，但是维护成本更高了 使用三分搜索树也可以节省空间
 * 更多字符串问题：子串查询，文件压缩 编译原理，DNA
 */
public class Trie { //这里不设置维泛型  character 到node节点的映射 其实就是字符串的集合  存储字符串，实现高效查询

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next; //character 到node节点的映射

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;  //根节点
    private  int size;

    //获得Trie
    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新的单词word  非递归写法
    public void add(String word){

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){  //遍历查找字符串中的一个一个字符
            char c = word.charAt(i);  //当前索引i所在的字符
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node()); //没有这个字符，创建一个节点
            cur = cur.next.get(c);
        }

        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word){

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null) //没有这个字符，返回false
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){

        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }




}
