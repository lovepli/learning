package com.datastructure.learning.basicTest.设计模式.建造者模式.注解链式.demo2;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
@Data
@ToString(callSuper = true)
public class Student extends Person {

    private String schoolName;
    private String grade;

    @Builder
    public Student(int weight, int height, String schoolName, String grade) {
        super(weight, height);
        this.schoolName = schoolName;
        this.grade = grade;
    }


}
