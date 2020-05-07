package com.datastructure.learning.basicTest.对象克隆.copyBean1;

import java.io.Serializable;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description:
 */
public class DemoInternal2 implements Serializable {

    private String internalName;

    private String internalValue;

    /*省略getter和setter方法*/

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getInternalValue() {
        return internalValue;
    }

    public void setInternalValue(String internalValue) {
        this.internalValue = internalValue;
    }


    @Override
    public String toString() {
        return "DemoInternal{" +
                "internalName='" + internalName + '\'' +
                ", internalValue='" + internalValue + '\'' +
                '}';
    }
}