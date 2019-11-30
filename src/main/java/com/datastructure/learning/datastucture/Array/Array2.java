package com.datastructure.learning.datastucture.Array;

/**
 * 使用泛型数组 可以是数组能够存放多种类型的数组
 * */
public class Array2<E> {

    private E[] data;
    private  int size;

    public Array2(int capacity){
        data= (E[]) new Object[capacity];
        size=0;
    }


    /**
     * 定义一个无参构造器,默认数组的容量capacity=10
     * */
    public Array2(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组是否为空
     * */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 向所有元素后面添加一个新的元素e 即向sizi处添加元素
     * */
    public void addLast(E e){

        //传入的参数错误异常IllegalArgumentException
        if (size==data.length) {
            throw new IllegalArgumentException("AddLast failed,Array is full");
        }
        data [size]=e;
        size++;
        //或者两行直接写成data[size++]=e

        //可以复用add的方法,可以将上面的内容全部替换成下面的这一个方法
        //  add(size,e);

    }

    /**
     * 在第index个位置插入一个新的元素e
     * */
    public void add(int index,E e){  //理解ppt的图片size的值：数组中第一个没有元素的位置
        //传入的参数错误异常IllegalArgumentException
        if (index<0 ||index>size) {
            throw new IllegalArgumentException("Add failed,Array is full;Require index >=0 and index<=size");
        }

        if (size==data.length) {
            // 容量动态扩容两倍
            resize(data.length*2);
        }
        //所有的元素往后移一个位置
        for (int i=size-1;i>=index;i--) {
            data[i + 1] = data[i];
        }
        data[index]=e;
        size++;
    }
    /**
     * 向所有元素前添加一个新的元素 即在第一个元素位置添加e
     * */
    public void addFirsrt(E e){
        add(0,e);

    }

    /**
     *获取index索引位置的元素
     * */
    public E get(int index){
        if (index <0 ||index >=size) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    //获取数组最后一个元素
   public E getLast(){
       return get(size - 1);

   }

   //获取第一个元素
   public  E getFirst(){
       return get(0);

   }

    /**
     * 修改index索引位置的元素为e
     * */
    void set(int index,E e){
        if (index <0 ||index >=size) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        data[index]=e;
    }

    /**
     * 查找数组中是否有元素e  TODO 泛型比较的是对象，不能== 引用比较，要equals值比较
     * */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在e，则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中元素e所在的索引，返回全部e的索引的组成的数组
     */
    public Array find2(E e) {
        Array array=new Array(30);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                array.addLast(i);
            }
        }
        return array;
    }



    /**
     * 查找数组中有多少个元素e
     * */
    public int find3(E e) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                count++;
            }
        }
        return count;
    }


    /**
     * 删除指定索引位置的元素,返回删除的元素
     * */
    public E remove(int index){
        //传入的参数错误异常IllegalArgumentException
        if (index<0 ||index>size) {
            throw new IllegalArgumentException("Remove failed,Index is Illegal.");
        }
        E ret =data[index];
        //所有的元素往后移一个位置
//        for (int i=size-1;i>=index;i--) {
//            data[i] = data[i+1];
//        }
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size]=null;  //TODO (闲逛的对象)loitering objects !=memory leak  使之置为空，让垃圾回收
        //删除元素之后，容量小到一定程度，进行缩容 后面采用的是懒缩容，缩容到1/4
//        if (size==data.length/2) {
//            // 容量动态缩容
//            resize(data.length/2);
//        }
        if (size==data.length/4 && data.length /2 !=0) {
            // 容量动态缩容
            resize(data.length/2);
        }
        return ret;
    }


    /**
     *从数组中删除第一个元素，返回删除的元素
     * */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 从数组中删除掉最后一个元素
     * */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     *从数组中删除元素e
     * */
    public void removeElement(E e){
        int index=find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 是否删除了数组中的元素e
     * */
    public boolean remove2Element(E e){
        int index=find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 删除数组中所有的元素e
     * */
    public void remove3Element(E e){
        int index=find3(e);
        if (index >=1){
            for (int i=0;i<size;i++){
                if (data[i]==e){
                    removeElement(e);
                }
            }
        }

    }


    /**
     * 重写toString的方法
     * */
    @Override
    public String toString(){

        StringBuffer res=new StringBuffer();
        res.append(String.format("Array:size=%d , capacity = %d\n",size,data.length));
        res.append("[");
        //实际只有size个元素
        for (int i=0;i<size;i++){
            res.append(data[i]);
            //是否是最后一个元素
            if (i!=size-1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

    /**
     * 实现数组的动态扩容和缩容  此方法为private 
     * */
    private void resize(int newCapacity){
        E [] newData= (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data=newData;

    }



    /**
     * 关于时间复杂度的分析
     *
     * 增：O(n)  注意：如果只对最后一个元素操作，依然是O(n)？ 因为resize？
     * 删：O(n)
     * 改：已知索引O(1);未知索引O(n)
     * 查：已知索引O(1);未知索引O(n)
     *
     * 均摊复杂度 和防止复杂度的震荡
     * */


}
