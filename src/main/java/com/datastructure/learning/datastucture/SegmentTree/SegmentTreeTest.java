package com.datastructure.learning.datastucture.SegmentTree;

/// 该测试用例来源：Leetcode 303. Range Sum Query - Immutable
/// https://leetcode.com/problems/range-sum-query-immutable/description/
public class SegmentTreeTest {

    //区间数字求和
    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        //一：使用匿名表达式实现转换器  对比堆中也使用过这样的写法
        SegmentTree<Integer> segTree1 =new SegmentTree<>(nums,new Merger<Integer>(){
            @Override
            public Integer merge (Integer a, Integer b){
                return a + b;
            }
        });

        //二：可以替换匿名函数，使用Java8里面的新的特性，兰么大表达式
        SegmentTree<Integer> segTree2=new SegmentTree<>(nums,(a, b) -> a+b);
        System.out.println(segTree2);

        //打印输出查询出的数元素和
        System.out.println(segTree2.query(0, 2));  //1
        System.out.println(segTree2.query(2, 5));  //-1
        System.out.println(segTree2.query(0, 5));  //3
    }
}
