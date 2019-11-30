package com.datastructure.learning.datastucture.Array;

public class Student {
    private String name;
    private int score;

    public Student(String studentName , int studnetScore){
        name=studentName;
        score=studnetScore;

    }

    @Override
    public String toString(){
        return String.format("Student(name: %s,score: %d)",name,score);
    }

    public static void main(String[] args) {

        //泛型数组，存储对象数据类型
        Array<Student> arr=new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",66));
        arr.addLast(new Student("Charlie",88));
        System.out.println(arr);
    }
}
