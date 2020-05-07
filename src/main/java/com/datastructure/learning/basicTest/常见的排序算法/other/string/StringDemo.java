package com.datastructure.learning.basicTest.常见的排序算法.other.string;

import java.util.Scanner;

/**
 * @author: lipan
 * @date: 2019-06-27
 * @description:
 */
public class StringDemo {
    public static void main(String[] args) {
        int englishCount = 0;// 英文字母个数
        int spaceCount = 0;// 空格个数
        int numCount = 0;// 数字个数
        int otherCount = 0;// 其他字符个数
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入一行字符：");
        String str = sc.nextLine();                // 取得控制台输入的一行字符
        char[] ch = str.toCharArray();         // 把取到的字符串变成一个char数组
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) {     // 判断是否为字母
                englishCount++;
            } else if (Character.isSpaceChar(ch[i])) {      // 判断是否为空格
                spaceCount++;
            } else if (Character.isDigit(ch[i])) {      // 判断是否为数字
                numCount++;
            } else {    // 以上都不是则认为是其他字符
                otherCount++;
            }
        }
        System.out.println("字母的个数：" + englishCount);
        System.out.println("数字的个数：" + numCount);
        System.out.println("空格的个数：" + spaceCount);
        System.out.println("其他字符的个数：" + otherCount);
    }
}



