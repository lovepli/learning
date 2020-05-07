package com.datastructure.learning.basicTest.对象克隆.copyBean2;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description: 参考https://blog.csdn.net/zyxhangiian123456789/article/details/98630429?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 */
public class Demo implements Cloneable {

    private String name;

    private String value;

    private DemoInternal demoInternal;

    /*省略getter和setter方法*/

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

    public DemoInternal getDemoInternal() {
        return demoInternal;
    }

    public void setDemoInternal(DemoInternal demoInternal) {
        this.demoInternal = demoInternal;
    }

    @Override
    public Demo clone() {
        Demo demo = null;
        try {
            demo = (Demo) super.clone(); //浅复制
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        demo.demoInternal = demoInternal.clone(); //深度复制
        return demo;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", demoInternal=" + demoInternal +
                '}';
    }
}