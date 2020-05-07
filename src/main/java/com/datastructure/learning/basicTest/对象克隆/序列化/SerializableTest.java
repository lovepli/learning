package com.datastructure.learning.basicTest.对象克隆.序列化;

import java.io.*;

/**
 * @author: lipan
 * @date: 2020-04-21
 * @description: 如何将一个 java 对象序列化到文件里
 *                在 java 中能够被序列化的类必须先实现 Serializable 接口，该接口没有任何抽象方法只是起到一个标记作用
 */
public class SerializableTest {

    public static void  f() throws IOException, ClassNotFoundException{
        //对象输出流  写入
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("/Users/lipan/Downloads/qrCode/sz00001.txt")));
        objectOutputStream.writeObject(new Car("凯迪拉克", 100));
        objectOutputStream.close();

        //对象输入流  读出
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/Users/lipan/Downloads/qrCode/sz00001.txt")));
        Car car = (Car)objectInputStream.readObject();
        System.out.println(car); //Car [brand=凯迪拉克, maxSpeed=100]
        objectInputStream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        /**
         * 这里的io流使用了装饰者模式!!!!!
         */

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
