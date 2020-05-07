package com.datastructure.learning.basicTest.类加载和垃圾回收机制;

/**
 * @author: lipan
 * @date: 2020-04-27
 * @description:  获取类对象对几种方式
 *
 * 1、类名.class
 * 2、对象this.getClass
 * 3、通过子类的实例获取父类对象
 * 4、反射：通过类名的字符串获取对象 Class.forName("...")
 * 5、通过反序列化
 * 6、通过克隆
 * 7、单粒模式获取getInstance()
 *
 */
public class StaticStuff {

    //子类
    class StaticStuffSon extends  StaticStuff{

    }

    //单例模式-- 懒汉
    static class Singleton{
        //static 保证只有一个实例对象
        private static Singleton instance;
        //私有构造函数，是为了不让使用者随便通过new Singleton()就能直接创造一个对象
        private Singleton(){}

        //对外提供获取实例的静态方法
        public static  Singleton getInstance(){
           if(instance == null) {
               instance= new Singleton(); //间接调用构造方法创建对象
           }
           return instance;
        }
    }

    public void test(){
        StaticStuff heStaticStuff = new StaticStuff();
        //类名.class
        System.out.println(StaticStuff.class);
        //this.getClass
        System.out.println(heStaticStuff.getClass());
        //通过子类的实例获取父类对象
        StaticStuffSon staticStuffSon =new StaticStuffSon();
       // Class<? extends StaticStuffSon> staticStuffSon1= staticStuffSon.getClass();
       // Class<?> staticStuff2=staticStuffSon1.getSuperclass();
        System.out.println(staticStuffSon.getClass().getSuperclass());

        try {
            //通过类名的字符串获取对象
            System.out.println(Class.forName("com.datastructure.learning.basicTest.类加载和垃圾回收机制.StaticStuff"));
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        StaticStuff s=new StaticStuff();
        s.test();
        //单例模式获取对象
        System.out.println("获取单例子对象"+Singleton.getInstance());



        /**
         * Object对象的方法： 7种方法
         * equqls() ,hashCode() ,toString() , getClass() ,notify() ,notifyAll() ,wait()
         */
        Object object=new Object();



    }




}

