package com.datastructure.learning.datastucture.Array;

/**
 * @auth0r: james
 * @date: 2019-05-29 23:23
 * 制作属于我们的数组类，实现增删改查
 * 普通数组，这里定义了只能存储 int类型的数据结构
*/
public class Array1 {

    private int[] data;
    private int size;

    /**
     * 定义一个有参构造器,传入数组的容量capacity构造Array
     * */
    public Array1(int capacity){
        //capacity容量,最多可以装的元素个数
        data=new int [capacity];
        //实际装的元素个数，设置初始值为0
        size=0;
    }

    /**
     * 定义一个无参构造器,默认数组的容量capacity=10  静态数组容量固定
     * */
    public Array1(){
        this(10);
        //this代表 Object 调用有参构造器新建一个默认的容量为10的数组对象
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
    public void addlast(int e){
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
    public void add(int index,int e){  //理解ppt的图片size的值：数组中第一个没有元素的位置
        //传入的参数错误异常IllegalArgumentException
        if (size==data.length) {
            throw new IllegalArgumentException("AddLast failed,Array is full");
        }
        if (index<0 ||index>size) {
            throw new IllegalArgumentException("Add failed,Array is full;Require index >=0 and index<=size");
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
    public void addFirsrt(int e){
        add(0,e);

    }

    /**
     *获取index索引位置的元素
     * */
    public int get(int index){
        if (index <0 ||index >=size) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素
     * */
    void set(int index,int e){
        if (index <0 ||index >=size) {
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        data[index]=e;
    }

    /**
     * 查找数组中是否有元素e
     * */
    public boolean contains(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
            return true;
            }
        }
         return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在e，则返回-1
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中元素e所在的索引，返回全部e的索引的组成的数组
     */
    public Array2  find2(int e) {
        Array2 array=new Array2(30);
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                array.addLast(i);
            }
        }
        return array;
    }



    /**
     * 查找数组中有多少个元素e
     * */
    public int find3(int e) {
        int count=0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                count++;
            }
        }
        return count;
    }


    /**
     * 删除指定索引位置的元素,返回删除的元素      //TODO 注意：在删除中 data[size] 的值永远娶不到
     * */
    public int remove(int index){
        //传入的参数错误异常IllegalArgumentException
        if (index<0 ||index>size) {
            throw new IllegalArgumentException("Remove failed,Index is Illegal.");
        }
        //
        int ret =data[index];

        //所有的元素往后移一个位置
//        for (int i=size-1;i>=index;i--) {
//            data[i] = data[i+1];
//        }
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
            size--;
        return ret;
    }


    /**
     *从数组中删除第一个元素，返回删除的元素
     * */
    public int removeFirst(){
        return remove(0);
    }


    /**
     * 从数组中删除掉最后一个元素
     * */
    public int removeLast(){
        return remove(size-1);
    }

    /**
     *从数组中删除元素e
     * */
    public void removeElement(int e){
        int index=find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 是否删除了数组中的元素e
     * */
    public boolean remove2Element(int e){
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
    public void remove3Element(int e){
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


}
