package com.datastructure.learning.basicTest.内部类.demo2.考题;

/**
 * @author: lipan
 * @date: 2020-04-25
 * @description:
 */
public class Test {
    public static void main(String[] args)  {
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}


class Outter {
    private int a = 1;

    class Inner {
        private int a = 2;

        public void print() {
            int a = 3;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            System.out.println("外部类变量：" + Outter.this.a);
        }
    }
}