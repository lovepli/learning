package com.datastructure.learning.basicTest.实用帮助类.fastjson的使用.jsonfield的使用;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description: 作用在setter和getter方法上
 *     <p>顾名思义，当作用在setter方法上时，就相当于根据 name 到 json中寻找对应的值，并调用该setter对象赋值。
 *     <p>当作用在getter上时，在bean转换为json时，其key值为name定义的值。
 */
public class Product {

    private String productName;
    private String desc;
    private String price;

    @JSONField(name="name")
    public String getProductName() {
        return productName;
    }

    @JSONField(name="NAME")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JSONField(name="desc")
    public String getDesc() {
        return desc;
    }

    @JSONField(name="DESC")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JSONField(name="price")
    public String getPrice() {
        return price;
    }

    @JSONField(name="PRICE")
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
