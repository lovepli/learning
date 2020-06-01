package com.datastructure.learning.datastucture.Array;

public class Array<E> {

  private E[] data;
  private int size;

  // 构造函数，传入数组的容量capacity构造Array
  public Array(int capacity) {
    data = (E[]) new Object[capacity];
    size = 0;
  }

  // 无参数的构造函数，默认数组的容量capacity=10
  public Array() {
    this(10);
  }

  // TODO 为了堆的heapitfy性质后来添加的  构造器是为了new产生对象
  // 将用户传来的数组拷贝一份放到data数组中
  public Array(E[] arr) {
    // 新建长度为arr.length的数组
    data = (E[]) new Object[arr.length];
    // 拷贝数组
    for (int i = 0; i < arr.length; i++) {
      data[i] = arr[i];
    }
    size = arr.length;
  }

  // TODO 将数组空间的容量变成newCapacity大小
  // 数组动态扩容和缩容 TODO 注意与构造函数区别！！！
  private void resize(int newCapacity) {
    // 新建容量的数组
    E[] newData = (E[]) new Object[newCapacity];
    // data数组内容复制给newData数组 注意此时data数组的size大小是与data.length成比例关系的，所有可以全部复制过去
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    // 重新赋值给data
    data = newData;
  }

  // 获取数组的容量
  public int getCapacity() {
    return data.length;
  }

  // 获取数组中的元素个数
  public int getSize() {
    return size;
  }

  // 返回数组是否为空
  public boolean isEmpty() {
    return size == 0;
  }

  // 在index索引的位置插入一个新元素e
  public void add(int index, E e) {

    if (index < 0 || index > size)
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

    // 添加元素之前进行判断，数组是否需要扩容
    if (size == data.length) resize(2 * data.length);

    // 数组移动
    for (int i = size - 1; i >= index; i--)
      // 向右移动
      data[i + 1] = data[i];

    data[index] = e;

    size++;
  }

  // 向所有元素后添加一个新元素
  public void addLast(E e) {
    add(size, e);
  }

  // 在所有元素前添加一个新元素
  public void addFirst(E e) {
    add(0, e);
  }

  // 获取index索引位置的元素
  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    return data[index];
  }

  // 获取数组最后一个元素
  public E getLast() {
    return get(size - 1);
  }

  // 获取第一个元素
  public E getFirst() {
    return get(0);
  }

  // 修改index索引位置的元素为e
  public void set(int index, E e) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("Set failed. Index is illegal.");
    data[index] = e;
  }

  // 查找数组中是否有元素e
  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) return true;
    }
    return false;
  }

  // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) return i;
    }
    return -1;
  }

  // 从数组中删除index位置的元素, 返回删除的元素
  public E remove(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("Remove failed. Index is illegal.");

    E ret = data[index];
    // 数组移动
    for (int i = index + 1; i < size; i++)
      // 向左移动
      data[i - 1] = data[i];
    size--;
    data[size] = null; // loitering objects != memory leak  进行垃圾回收处理

    // 删除之后进行必要的数组缩容，节省内存空间
    if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
    return ret;
  }

  // 从数组中删除第一个元素, 返回删除的元素
  public E removeFirst() {
    return remove(0);
  }

  // 从数组中删除最后一个元素, 返回删除的元素
  public E removeLast() {
    return remove(size - 1);
  }

  // 从数组中删除元素e
  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) remove(index);
  }

  // 交换元素的位置
  public void swap(int i, int j) {

    if (i < 0 || i >= size || j < 0 || j >= size)
      throw new IllegalArgumentException("Index is illegal.");

    E t = data[i];
    data[i] = data[j];
    data[j] = t;
  }

  @Override
  public String toString() {

    StringBuilder res = new StringBuilder();
    res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
    res.append('[');
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if (i != size - 1) res.append(", ");
    }
    res.append(']');
    return res.toString();
  }
}
