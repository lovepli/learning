package com.datastructure.learning.datastucture.AVLTree.AVLSetAndMap;

import com.datastructure.learning.datastucture.AVLTree.AVLTree;
import com.datastructure.learning.datastucture.SetAndMap.set.Set;

public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avl;  //只需要一个key值，不需要value，这里给value为object=null

    public AVLSet(){
        avl = new AVLTree<>();
    }

    @Override
    public int getSize(){
        return avl.getSize();
    }

    @Override
    public boolean isEmpty(){
        return avl.isEmpty();
    }

    @Override
    public void add(E e){
        avl.add(e, null);
    }  //value 直接设置为null

    @Override
    public boolean contains(E e){
        return avl.contains(e);
    }  //根据key来查询

    @Override
    public void remove(E e){
        avl.remove(e);
    }
}
