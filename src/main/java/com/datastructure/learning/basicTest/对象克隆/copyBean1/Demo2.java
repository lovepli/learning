package com.datastructure.learning.basicTest.对象克隆.copyBean1;

import java.io.Serializable;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description: 参考https://blog.csdn.net/zyxhangiian123456789/article/details/98630429?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 */
public class Demo2 implements Serializable {

    private String name;

    private String value;

    private DemoInternal2 demoInternal2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DemoInternal2 getDemoInternal2() {
        return demoInternal2;
    }

    public void setDemoInternal2(DemoInternal2 demoInternal2) {
        this.demoInternal2 = demoInternal2;
    }

    @Override
    public String toString() {
        return "Demo2{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", demoInternal2=" + demoInternal2 +
                '}';
    }
}