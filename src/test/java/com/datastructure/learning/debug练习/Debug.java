package com.datastructure.learning.debug练习;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

/**
 * @author: lipan
 * @date: 2020-04-28
 * @description:  bug调试练习
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Debug {

    //跳到选择的某一个值
    @Test
    public void ifDebug() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }


    //测试回退
    @Test
    public void dropFrameDebug() {
        int i = 99;
        method1(i);

    }

    private void method1(int i) {
        System.out.println("method1" + i);
        method2(i);
    }

    private void method2(int j) {
        j++;
        System.out.println("methods" + j);
    }

    //测试选择执行的线程
    @Test
    public void multiThreadTest() {
        new Thread(() -> {
            System.out.println("1.窗前明月光");
        }, "线程1").start();
        new Thread(() -> {
            System.out.println("2.疑是地上霜");
        }, "线程2").start();
        System.out.println("3.举头望明月");
        System.out.println("4.低头思故乡");

    }

    /**
     * Stream流的使用
     */
    @Test
    public void streamTest() {

        int[] result = IntStream.of(10, 87, 97, 43, 121, 20, 43)
                .filter((element) -> element > 10)  //筛选出大于10的元素
                .map((element) -> element * 2)           //所有元素值乘以2
                .distinct()                             //去除重复的值
                .sorted()                               //从小到达进行排序
                .toArray();                             //转换为数组
    }

}
