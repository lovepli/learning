package com.datastructure.learning.basicTest.threadlocal关键字;

/**
 * @author: lipan
 * @date: 2020/5/27
 * @description:
 */
public class ThreadLocalUsage05 {

    public static void main(String[] args) {
        Student student = init();
        new NameService().getName(student);
        new SexService().getSex(student);
        new ScoreService().getScore(student);
    }

    private static Student init() {
        Student student = new Student();
        student.name = "Lemon";
        student.sex = "female";
        student.score = "100";
        return student;
    }

}

class Student {

    /**
     * 姓名、性别、成绩
     */
    String name;
    String sex;
    String score;

}

class NameService {

    public void getName(Student student) {
        System.out.println(student.name);
    }

}

class SexService {

    public void getSex(Student student) {
        System.out.println(student.sex);
    }

}

class ScoreService {

    public void getScore(Student student) {
        System.out.println(student.score);
    }

}
// 分析：
// 从上面的代码中可以看出，每个类的方法都需要传递学生的信息才可以获取到正确的信息，这样做能达到目的
//
// 但是每个方法都需要学生信息作为入参，这样未免有点繁琐，且在实际使用中通常在每个方法里面还需要对每个学生信息进行判空，这样的代码显得十分冗余，不利于维护。
//
// 也许有人会说，我们可以将学生信息存入到一个共享的Map中，需要学生信息的时候直接去Map中取，如下图所示：

//其实这也是一种思路，但是在并发环境下，如果要使用Map，那么就需要使用同步的Map，比如ConcurrentHashMap或者Collections.SynchronizedMap()，前者底层用的是CAS和锁机制，后者直接使用的是synchronized，性能也不尽人意。
