package com.datastructure.learning.basicTest.static关键字;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式：保留唯一副本
 */
class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {  //加锁
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 单例模式：使用静态代码块通常来说是为了对静态变量进行一些初始化操作
 */
class Singleton2 {
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 枚举：使用静态代码块通常来说是为了对静态变量进行一些初始化操作
 */
enum WeekDayEnum {
    MONDAY(1,"周一"),
    TUESDAY(2, "周二"),
    WEDNESDAY(3, "周三"),
    THURSDAY(4, "周四"),
    FRIDAY(5, "周五"),
    SATURDAY(6, "周六"),
    SUNDAY(7, "周日");

    private int code;
    private String desc;

    WeekDayEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    //定义全局变量 命名规范：全部大写，多个单词之间通过下划线隔开
    //必须强调的一点是，当声明一个final的引用时， 只能说明该引用是不可变的(WEEK_ENUM_MAP 不可变)，但是数据是可变的，所以我们可以往map中添加元素
    private static final Map<Integer, WeekDayEnum> WEEK_ENUM_MAP = new HashMap<Integer, WeekDayEnum>();
    //WEEK_ENUM_MAP=new HashMap<Integer, WeekDayEnum>();  //这里引用被final修饰，是不变的，所以编译报错

    // 对map进行初始化
    static {
        for (WeekDayEnum weekDay : WeekDayEnum.values()) {
            WEEK_ENUM_MAP.put(weekDay.getCode(), weekDay);
        }
    }

    public static WeekDayEnum findByCode(int code) {
        return WEEK_ENUM_MAP.get(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


public class Demo3 {
    /**
     * 第三种最经典的场景莫过于单例模式了，单例模式由于必须全局只保留一个副本，所以天然和static的初衷是吻合的，
     * 用static来修饰再合适不过了
     */
}
