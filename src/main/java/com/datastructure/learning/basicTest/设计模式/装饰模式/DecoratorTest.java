package com.datastructure.learning.basicTest.设计模式.装饰模式;

import java.io.*;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description: 装饰模式
 * 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个
 * 接口，装饰对象持有被装饰对象的实例
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();  //实现的方法
    }

    /**
     * spring中使用了装饰模式的例子：
     * 这里的io流使用了装饰者模式!!!!!
     */
    public void f() throws FileNotFoundException {

        /**
         * 透明写法
         */
        InputStream is =new FileInputStream("test.txt");
        InputStream bfis=new BufferedInputStream(is);
        InputStream dtis=new DataInputStream(bfis);

        /**
         * 半透明写法
         */
        InputStream f1=new FileInputStream("d:/1.txt");
        InputStreamReader f2=new InputStreamReader(f1);
        BufferedReader f3=new BufferedReader(f2);
    }

}


