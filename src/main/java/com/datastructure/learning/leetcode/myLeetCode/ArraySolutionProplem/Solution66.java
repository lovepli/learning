package com.datastructure.learning.leetcode.myLeetCode.ArraySolutionProplem;


import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author: 59688
 * @date: 2021/3/9
 * @description: 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 标签：数组
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution66 {
    /**
     * 一开始看到这题，我就起了歪主意了。什么整数数组转char数组啊，再转字符串啊，字符串再转整数啊，再加一啊，再转字符串啊，再转char数组啊，再转整数数组啊，就快活起来了。
     * 后来发现总是有nuberformatexception，才意识到长度超出了限制了。
     *
     * 思路是把数组先转化成数字，加一再转化回来，自己测试也成功了，提交之后发现忽略了整型溢出的情况(TODO 答案报错！！)
     * (TODO 答案报错！！)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        String str="";
        for(int i=digits.length-1;i>=0;i--){
            str=digits[i]+str;
        }
        //System.out.println(str);
        int [] arr0=new int[0];
        try{
        // 字符串转数字
        int in = Integer.parseInt(str); // TODO 这一行出现整型溢出问题！！！
        // 数字转字符串
        String  str1 =String.valueOf(in+1);
        //System.out.println(str1);
        // 字符串转数组
        arr0=new int[str1.length()];
        // 遍历字符串
        char [] chars =str1.toCharArray();
        for(int i=0;i<chars.length;i++){ // 倒序赋值
           // System.out.println(chars[i]); // 字符
           // System.out.println(String.valueOf(chars[i])); // 字符转为字符串
            arr0[i] =Integer.parseInt(String.valueOf(chars[i]));
        }
        } catch (NumberFormatException e) {
            //在转换过程中需要注意,因为字符串中可能会出现非数字的情况,所以在转换的时候需要捕捉处理异常
            e.printStackTrace();
        }
      return  arr0;
    }

    /**
     * 使用BigDecimal进行上一个方法的修改，针对大的数据,击败100%%用户，哈哈行啊
     * @param digits
     * @return
     */
    public int[] plusOne_1(int[] digits) {
        String str="";
        for(int i=digits.length-1;i>=0;i--){
            str=digits[i]+str;
        }
        System.out.println(str);
        int [] arr0=new int[0];
        try{
            // 字符串转数字
            BigInteger bigInteger=new BigInteger(str);
            BigInteger bigInteger0=new BigInteger("1");
            BigInteger result =bigInteger.add(bigInteger0);
            // 数字转字符串
            String  str1 =String.valueOf(result);
            System.out.println(str1);
            // 字符串转数组
            arr0=new int[str1.length()];
            // 遍历字符串
            char [] chars =str1.toCharArray();
            for(int i=0;i<chars.length;i++){ // 倒序赋值
                // System.out.println(chars[i]); // 字符
                // System.out.println(String.valueOf(chars[i])); // 字符转为字符串
                arr0[i] =Integer.parseInt(String.valueOf(chars[i]));
            }
        } catch (NumberFormatException e) {
            //在转换过程中需要注意,因为字符串中可能会出现非数字的情况,所以在转换的时候需要捕捉处理异常
            e.printStackTrace();
        }
        return  arr0;
    }


    /**
     * 老老实实数组里面遍历求。
     * 思路：
     * 从最后一位出发，确定这个 1 应该加在哪个位置。
     * 如果找不到位置，说明溢出了当前数组。新建一个 长度+1 的数组即可。
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    /**
     * 思路：分两种情况，若全是9，则需要新建数组（100...00）,否则原地更改那些有进位的
     * @param digits
     * @return
     */
    public int[] plusOne3(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;//每次更新为+1后取余
            if(digits[i]!=0) return digits;//若是一旦没有进位，也就是非0，则+1操作结束
        }
        //若每一位都进位了，即999这样的情况，则新建数组
        int[]newD=new int[n+1];
        newD[0]=1;
        return newD;
    }

    public static void main(String[] args) {
     int [] digits={1,2,3}; // 124
      //int [] digits={9,9,9};
      int [] arr=  new Solution66().plusOne_1(digits);
      System.out.println(Arrays.toString(arr));
    }
}
