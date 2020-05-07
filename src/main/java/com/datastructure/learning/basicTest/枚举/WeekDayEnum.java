package com.datastructure.learning.basicTest.枚举;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description:
 */
public enum WeekDayEnum {
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

    private static final Map<Integer, WeekDayEnum> WEEK_ENUM_MAP = new HashMap<Integer, WeekDayEnum>();

    /**
     * 静态代码块通常来说是为了对静态变量进行一些初始化操作，比如单例模式、定义枚举类
     */
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

