package com.datastructure.learning.basicTest.对象克隆.copyBean2;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description:
 */
public class DemoInternal implements Cloneable {

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
    public DemoInternal clone() {
        DemoInternal demoInternal = null;
        try {
            demoInternal = (DemoInternal) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return demoInternal;
    }

    @Override
    public String toString() {
        return "DemoInternal{" +
                "internalName='" + internalName + '\'' +
                ", internalValue='" + internalValue + '\'' +
                '}';
    }
}