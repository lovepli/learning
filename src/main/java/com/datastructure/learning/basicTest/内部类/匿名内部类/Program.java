package com.datastructure.learning.basicTest.内部类.匿名内部类;

/**
 * @author: lipan
 * @date: 2020-05-07
 * @description:
 */
public class Program {
    public static void main(String[] args) {
        ISay say = new ISay() {
            public void sayHello() {
                System.out.println("Hello java!");
            }

            @Override
            public void sayGoodBye() {
                System.out.println("good bye!");
            }
        };

        say.sayHello();
        say.sayGoodBye();
    }

}

/**
 * 初看上去，就好象在“不提供接口实现的情况下，直接new了一个接口实例”，对于C#er来说，有一种尽毁三观的赶脚。
 *
 * 还好这只是假象，观察bin目录下的class输出，会发现有一个类似Program$1.class的文件，如果反编译观察一下，发现原来是编译器自动生成一个类Program$1:
 *
 * 总结：如果有些场合，只需要临时需要创建一个接口的实现类，就可以使用匿名类直接new接口如果有些场合，只需要临时需要创建一个接口的实现类，上面的"技巧"可以用来简化代码.
 */
