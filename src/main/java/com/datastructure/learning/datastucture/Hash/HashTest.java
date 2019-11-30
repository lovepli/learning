package com.datastructure.learning.datastucture.Hash;

import java.util.HashSet;  //hash表作为底层的集合
import java.util.HashMap;

public class HashTest {

    public static void main(String[] args) {

        int a = 42;
        //hashCode()方法是Object的方法，需要将int类型转换为包装类Integer类型
        System.out.println(((Integer)a).hashCode()); // 42 对于整型来说，他的值是多少，返回的hashCode值就是多少

        int b = -42;
        System.out.println(((Integer)b).hashCode());  //-42

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());//219937201

        String d = "imooc";
        System.out.println(d.hashCode());//100327135

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println();

        Student student = new Student(3, 2, "Bobo", "Liu");
        System.out.println(student.hashCode());//

        HashSet<Student> set = new HashSet<>();
        set.add(student);  //存储过程，自动掉用Student的hashCode()方法计算出一个索引值然后存储到相应位置中

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);  //学生 分数

        Student student2 = new Student(3, 2, "Bobo", "Liu");
        System.out.println(student2.hashCode());

        //Java默认的Object中的hashCode()方法是根据一个对像的地址将它映射成一个hashCode值，这里如果重写HashCode()方法，
        // 默认使用的是Object中的hashCode()方法，返回的student1和student2的hash值不相同
    }
}
