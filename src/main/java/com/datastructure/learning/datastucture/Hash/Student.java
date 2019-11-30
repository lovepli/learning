package com.datastructure.learning.datastucture.Hash;

/**
 * 符合类型
 */
public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade, int cls, String firstName, String lastName){
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //重写覆盖 自定义哈希函数   确定 返回的hash值相同，即作为key存储的值相同
    @Override
    public int hashCode(){

        int B = 31;  //随便取得一个素数
        int hash = 0;
        hash = hash * B + ((Integer)grade).hashCode();//转成Integer类型再取Integer类型的hashCode()
        hash = hash * B + ((Integer)cls).hashCode();
        hash = hash * B + firstName.toLowerCase().hashCode(); //String字符串全部转换为小写字符串再取字符串的哈希函数
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    //重写覆盖  hashCode()必须要重写 equals(Object o)函数 确定Object相同
    @Override
    public boolean equals(Object o){ //注意这里不能为 Student类型

        if(this == o)
            return true;

        if(o == null)
            return false;

        if(getClass() != o.getClass())
            return false;

        Student another = (Student)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
