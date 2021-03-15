package com.datastructure.learning.leetcode.myLeetCode;

import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/15
 * @description: 补充知识点 Arrays对象基础用法总结：
 * import java.util.Arrays
 *
 * Arrays.sort() 对数组的排序(从小到大)
 * Arrays.binarySerch() 二分查找，找到则定位元素下标
 * Arrays.toString()数组的打印
 * Arrays.fill() 数组的填充
 * Arrays.equals() 判断两个数组大小是否相等
 * Arrays.asList()用于将数组转为集合
 * Arrays.copyOf 数组的拷贝
 */
public class TodoArrays {

    /**
     * TODO 补充知识点:Arrays.copyOfRange()方法
     * copyOfRange是输入java.util包中的Arrays类的静态内部方法，可以被类直接调用。下面以int[]型传递参数为例，来测试其用法。
     *
     * copyOfRange(int []original,int from,int to),original为原始的int型数组，from为开始角标值，to为终止角标值。
     * （其中包括from角标，不包括to角标。即处于[from,to)状态）下面是它的一个测试用法：
     */
    public void test2(){
        int [] arr={0,1,2,3,4,5,6,7,8};
        // 既从0角标到4角标复制到新的数组中，copyArr为：{0,1,2,3,4}
        int [] copyArr =Arrays.copyOfRange(arr,0,5);

        for (Integer i:copyArr){
            System.out.print(i+" ");
        }
    }

    /**
     * TODO 补充知识点:Arrays.toString()数组的打印
     * toString用法
     * toSting可以将数组直接转化为字符串，可以以字符串的方式将数组输出。
     * [1, 2, 3, 4, 5]
     */
    public void test3(){
        int[] a = {1,2,3,4,5};
        //直接用println会输出该数组地址
        //System.out.println(a);

        String str = Arrays.toString(a);
        System.out.println(str);
        //输出结果：[1, 2, 3, 4, 5]
        //连同中括号一并输出，如果不想这样就要想其他办法了。
        //需要自己构造一个字符串将转化后的数组保存起来。
    }

    /**
     *TODO 补充知识点:Arrays.sort()对数组的排序(从小到大)
     *sort用法
     *sort可以将数组内的数字排列（由小到大）。使用该方法后此数组就被排列。
     */
    public void test4(){
        int[] a = {4,2,7,9,4,8};
        Arrays.sort(a,1,5);
        for (int i = 0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
        //输出结果：2 4 4 7 8 9
        //当然，如果想对数组区间内的元素进行排序，则可以这样
        //Arrays.sort(a,1,5);
        // 输出结果：4 2 4 7 9 8
        //注意:从起始位置到结束位置，取头不取尾
    }

    /**
     * TODO 补充知识点:Arrays.fill()数组的填充
     * fill用法
     * 一个数组中的某些元素未被定义，那么它们就会默认为0，如果想默认为其他数字呢，那么fill也许是个不错的方法。
     */
    public void test5(){
        int[] a = {6,6,6,6,6,6};
        Arrays.fill(a,9);
        for (int i : a) {
            System.out.print(i+" ");
        }
        //输出结果：9 9 9 9 9 9
        //
        //当然，如果想让当中某些数字填充，则可以这样
        //Arrays.fill(a,2,5,9);
        // 输出结果：6 6 9 9 9 6
        //注意:从起始位置到结束位置，取头不取尾
    }

    /**
     * TODO 补充知识点:Arrays.equals() 判断两个数组大小是否相等
     */
    public void test6(){
        int[] numGroup = {25,12,68,78,33,55};
        int[] numGroup02 = {35,12,68,78,33,55};
        Boolean judge=Arrays.equals(numGroup, numGroup02);
        System.out.println("判断两个数组是否相等:"+judge); // false

        int[] numGroup03 = numGroup.clone();
        System.out.println("克隆后数组元素是否相等:Arrays.equals(numGroup, numGroup03):"+"\n"+Arrays.equals(numGroup, numGroup03)); // true
    }

    /**
     * TODO 补充知识点:Arrays.binarySerch() 二分查找，找到则定位元素下标,如果不存在就返回负数
     */
    public  void test7(){
        //二分法查找前提是序列必须从小到大排好序
        int[] numGroup = {12,34,68,78,98,123};
        int index=Arrays.binarySearch(numGroup, 98); //4
        System.out.println("该元素下标为:"+index);

    }

    /**
     * TODO 补充知识点:Arrays.asList() 查看数组中的特定值
     *  * Arrays.asList() 查看数组中的特定值
     *    asList()可用于将数组转为集合
     *  * list.contains(o)，比较list是否包含o
     */
    public void test8(){
        int[] numGroup = {25,12,68,78,33,55};
        Boolean judge= Arrays.asList(numGroup).contains(numGroup);
        System.out.println("查看数组中的特定值:"+judge); // true
    }

    /**
     * TODO 补充知识点:Arrays.copyOf 数组的拷贝
     */
    public  void test9(){
        int[] numGroup = {25,12,68,78,33,55};
        int[] numGroup02=null;
        numGroup02=Arrays.copyOf(numGroup, 9);
        System.out.println(Arrays.toString(numGroup02)); // [25,12,68,78,33,55,0,0,0]
    }
}
