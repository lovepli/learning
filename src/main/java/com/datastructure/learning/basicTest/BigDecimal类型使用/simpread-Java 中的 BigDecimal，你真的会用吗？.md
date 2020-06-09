> 本文由 [简悦 SimpRead](http://ksria.com/simpread/) 转码， 原文地址 https://mp.weixin.qq.com/s/ddZ3G5u09wDoYTCl5eP-zg

![][img-0]

> 作者：LanceToBigData
> 
> cnblogs.com/zhangyinhua/p/11545305.html

一、BigDecimal 概述
---------------

Java 在 java.math 包中提供的 API 类 BigDecimal，用来对超过 16 位有效位的数进行精确的运算。双精度浮点型变量 double 可以处理 16 位有效数，但在实际应用中，可能需要对更大或者更小的数进行运算和处理。

一般情况下，对于那些不需要准确计算精度的数字，我们可以直接使用 Float 和 Double 处理，但是 Double.valueOf(String) 和 Float.valueOf(String) 会丢失精度。所以开发中，如果我们需要精确计算的结果，则必须使用 BigDecimal 类来操作。

BigDecimal 所创建的是对象，故我们不能使用传统的 +、-、*、/ 等算术运算符直接对其对象进行数学运算，而必须调用其相对应的方法。方法中的参数也必须是 BigDecimal 的对象。构造器是类的特殊方法，专门用来创建对象，特别是带有参数的对象。

二、BigDecimal 常用构造函数
-------------------

### 2.1、常用构造函数

*   **BigDecimal(int)**
    

创建一个具有参数所指定整数值的对象

*   **BigDecimal(double)**
    

创建一个具有参数所指定双精度值的对象

*   **BigDecimal(long)**
    

创建一个具有参数所指定长整数值的对象

*   **BigDecimal(String)**
    

创建一个具有参数所指定以字符串表示的数值的对象

### 2.2、使用问题分析

使用示例：

```
BigDecimal a =new BigDecimal(0.1);
System.out.println("a values is:"+a);
System.out.println("=====================");
BigDecimal b =new BigDecimal("0.1");
System.out.println("b values is:"+b);
```

结果示例：

```
a values is:0.1000000000000000055511151231257827021181583404541015625
=====================
b values is:0.1
```

原因分析：

1）参数类型为 double 的构造方法的结果有一定的不可预知性。有人可能认为在 Java 中写入 newBigDecimal(0.1) 所创建的 BigDecimal 正好等于 0.1（非标度值 1，其标度为 1），但是它实际上等于 0.1000000000000000055511151231257827021181583404541015625。这是因为 0.1 无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。

2）String 构造方法是完全可预知的：写入 newBigDecimal(“0.1”) 将创建一个 BigDecimal，它正好等于预期的 0.1。因此，比较而言， 通常建议优先使用 String 构造方法。

3）当 double 必须用作 BigDecimal 的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：先使用 Double.toString(double) 方法，然后使用 BigDecimal(String) 构造方法，将 double 转换为 String。要获取该结果，请使用 static valueOf(double) 方法。Java 知音公众号内回复 “面试题聚合”，送你一份面试题宝典

三、BigDecimal 常用方法详解
-------------------

### 3.1、常用方法

*   **add(BigDecimal)**
    

BigDecimal 对象中的值相加，返回 BigDecimal 对象

*   **subtract(BigDecimal)**
    

BigDecimal 对象中的值相减，返回 BigDecimal 对象

*   **multiply(BigDecimal)**
    

BigDecimal 对象中的值相乘，返回 BigDecimal 对象

*   **divide(BigDecimal)**
    

BigDecimal 对象中的值相除，返回 BigDecimal 对象

*   **toString()**
    

将 BigDecimal 对象中的值转换成字符串

*   **doubleValue()**
    

将 BigDecimal 对象中的值转换成双精度数

*   **floatValue()**
    

将 BigDecimal 对象中的值转换成单精度数

*   **longValue()**
    

将 BigDecimal 对象中的值转换成长整数

*   **intValue()**
    

将 BigDecimal 对象中的值转换成整数

### 3.2、BigDecimal 大小比较

java 中对 BigDecimal 比较大小一般用的是 bigdemical 的 compareTo 方法

```
int a = bigdemical.compareTo(bigdemical2)
```

返回结果分析：

```
a = -1,表示bigdemical小于bigdemical2；
a = 0,表示bigdemical等于bigdemical2；
a = 1,表示bigdemical大于bigdemical2；
```

举例：a 大于等于 b

```
new bigdemica(a).compareTo(new bigdemical(b)) >= 0
```

四、BigDecimal 格式化
----------------

由于 NumberFormat 类的 format() 方法可以使用 BigDecimal 对象作为其参数，可以利用 BigDecimal 对超出 16 位有效数字的货币值，百分值，以及一般数值进行格式化控制。

以利用 BigDecimal 对货币和百分比格式化为例。首先，创建 BigDecimal 对象，进行 BigDecimal 的算术运算后，分别建立对货币和百分比格式化的引用，最后利用 BigDecimal 对象作为 format() 方法的参数，输出其格式化的货币值和百分比。

```
NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用 
NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用 
percent.setMaximumFractionDigits(3); //百分比小数点最多3位 

BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
BigDecimal interestRate = new BigDecimal("0.008"); //利率   
BigDecimal interest = loanAmount.multiply(interestRate); //相乘

System.out.println("贷款金额:\t" + currency.format(loanAmount)); 
System.out.println("利率:\t" + percent.format(interestRate)); 
System.out.println("利息:\t" + currency.format(interest)); 
```

结果：

```
贷款金额: ￥15,000.48 利率: 0.8% 利息: ￥120.00
```

BigDecimal 格式化保留 2 为小数，不足则补 0：

```
public class NumberFormat {

    public static void main(String[] s){
        System.out.println(formatToNumber(new BigDecimal("3.435")));
        System.out.println(formatToNumber(new BigDecimal(0)));
        System.out.println(formatToNumber(new BigDecimal("0.00")));
        System.out.println(formatToNumber(new BigDecimal("0.001")));
        System.out.println(formatToNumber(new BigDecimal("0.006")));
        System.out.println(formatToNumber(new BigDecimal("0.206")));
    }
    /**
     * @desc 1.0~1之间的BigDecimal小数，格式化后失去前面的0,则前面直接加上0。
     * 2.传入的参数等于0，则直接返回字符串"0.00"
     * 3.大于1的小数，直接格式化返回字符串
     * @param obj传入的小数
     * @return
     */
    public static String formatToNumber(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.00");
        if(obj.compareTo(BigDecimal.ZERO)==0) {
            return "0.00";
        }else if(obj.compareTo(BigDecimal.ZERO)>0&&obj.compareTo(new BigDecimal(1))<0){
            return "0"+df.format(obj).toString();
        }else {
            return df.format(obj).toString();
        }
    }
}
```

结果为：

```
3.44
0.00
0.00
0.00
0.01
0.21
```

五、BigDecimal 常见异常
-----------------

### 5.1、除法的时候出现异常

`java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result`

**原因分析：**

通过 BigDecimal 的 divide 方法进行除法时当不整除，出现无限循环小数时，就会抛异常：java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.

**解决方法：**

> divide 方法设置精确的小数点，如：divide(xxxxx,2)

六、BigDecimal 总结
---------------

### 6.1、总结

在需要精确的小数计算时再使用 BigDecimal，BigDecimal 的性能比 double 和 float 差，在处理庞大，复杂的运算时尤为明显。故一般精度的计算没必要使用 BigDecimal。  
尽量使用参数类型为 String 的构造函数。

BigDecimal 都是不可变的（immutable）的， 在进行每一次四则运算时，都会产生一个新的对象 ，所以在做加减乘除运算时要记得要保存操作后的值。

### 6.2、工具类推荐

```
package com.vivo.ars.util;
import java.math.BigDecimal;

/**
 * 用于高精确处理常用的数学运算
 */
public class ArithmeticUtils {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1    被加数
     * @param v2    加数
     * @param scale 保留scale 位小数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v1);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static String remainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数  BigDecimal
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 比较大小
     *
     * @param v1 被比较数
     * @param v2 比较数
     * @return 如果v1 大于v2 则 返回true 否则false
     */
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        if (bj > 0)
            res = true;
        else
            res = false;
        return res;
    }
}
```

**END**

**精彩推荐**

[一百期 Java 面试题汇总](http://mp.weixin.qq.com/s?__biz=MzIyNDU2ODA4OQ==&mid=2247484532&idx=1&sn=1c243934507d79db4f76de8ed0e5727f&chksm=e80db202df7a3b14fe7077b0fe5ec4de4088ce96a2cde16cbac21214956bd6f2e8f51193ee2b&scene=21#wechat_redirect)

[SpringBoot 内容聚合](http://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247486774&idx=3&sn=a13875e4a12fc7a32d39d6ac4ca15b33&chksm=fc7a6098cb0de98e56ee49654d2b31ea0309709166ebbf6d820fc41570bc6445b514b4940b6b&scene=21#wechat_redirect)

[IntelliJ IDEA 内容聚合](http://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247486813&idx=2&sn=509ba858333ac30a2470b817cd6dc5e4&chksm=fc7a60f3cb0de9e5fb1b1f5d36239d97a82be70776020e4113a3dbba57b8afee5e3e218abc6e&scene=21#wechat_redirect)

[Mybatis 内容聚合](http://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247486774&idx=2&sn=71fd7375bce8907e5d325b25199c9f8c&chksm=fc7a6098cb0de98e326777f8231be4ddc9c37d2610912e126fb4dc89c32627fcec60353cb638&scene=21#wechat_redirect)

![][img-1]

```
我知道你 “在看”
```

[img-0]:data:image/gif;base64,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//////////////////////////////////////////////8I/wDpCRxIsKDBgwgTKlzIsKHDhxAjSpxIsaLFixgzatzIsaPHjyBDihxJsqTJkyhTqlzJsqXLlzBjypxJs6bNmzhz6tzJs6fPn0CDCh1KtKjRo0iTKl3KtKnTp1CjSp1KtarVq1izat3KtavXr2DDih1LtqzZs2jTql3Ltq3bt3Djyp1Lt67du3jz6t3Lt6/fv4ADCx5MuLDhw4gTK17MuLHjx5AjS55MubLly5gza97MubPnz6BDix5NurTp06hTq17NurXr17Bjy55Nu7bt27hz697Nu7fv38CDCx9OvLjx48iTK1/OvLnz59CjS5/+1x22a+Soa3eubtu1Y8rCX//TBm+7eeLwuF0LjwxZ+PfXsKk7T5+3OvXvkeWqpOv9e17yPQSPO+p4ow02CCao4IIMNujggxBGKOGEFFZo4YUYZqjhhhx22KA26qgDT3n1aQWPd+4hAwolgwDiByCE6AKef8f8Qp5B6V3TSSNcUNGEEkX8IKQPRBZp5JFIJqnkkkw26eSTUEYp5ZRUVmnllVhmSaSQPwxhBBNOWMGII7vIR2KJUJ24HjKjUPIMIc5UU80zf/QRCCGguOefMr9c082I15jiiBVLENElEksw8UQVVmDBxaOQRirppJRWaumlmGaq6aacdurpp6CGKuqopD6KxRVWUOEEE0sY0aURTnD/AUkx2JyJZlJqKoOMLiw+Q405A2kjyB589AHIIJe0p6t/pjRSxRFEGNFEF1w0AkknoOSi7bbcduvtt+CGK+645JZr7rnopqvuuuy26+674o7yiSWOMNIFFUoQiYQVjfQy361Gqdker4I8U42t9FgzbLF98OFHIJSM4p4ukGDB6rSMRFKJJZmAMgq8IIcs8sgkl2zyySiLCwokXDTxAw9FcGGKNgAL5U421oSXSyGD+OqOQOUNSI0gDffhRx9IGw2jIVYw0YQVizTyyNSSSLLxJZ9km/LWXHft9ddgby0vy0z8UEQVnWBTc0/wYMNLeLz2XM3PQA94zTOAEFvsH4LU/1nsHnnccUcYijSySBddLDL1I5FYvXEmo0Qe9uSUV2755SiHYgkjTPhAxBW7/Lu2Td2tp0wmhPRMjehAW/NMIA3zIbvsdgLyhx6C3wHHG2rkYEIPS0RhhReKTx2Jxhx7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

[img-1]:data:image/jpeg;base64,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