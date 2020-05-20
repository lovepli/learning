package com.datastructure.learning.basicTest.实用帮助类.fastjson的使用.jsonfield的使用;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:
 */

public class JsonObjectTest {

    public static void main(String[] args) {
        Product product = new Product();
        product.setProductName("产品");
        product.setDesc("这是一个产品");
        product.setPrice("22.3");

        String jsonStr = JSONObject.toJSONString(product);
        System.out.println("转换为json:" + JSONObject.toJSONString(product));

        //jsonStr = jsonStr.toUpperCase();
        System.out.println(jsonStr);

        product = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Product.class);
        System.out.println(product.toString());
    }

   // @Test
    public void test() {
        Product product = new Product();
        product.setProductName("产品");
        product.setDesc("这是一个产品");
        product.setPrice("22.3");

        String jsonStr = JSONObject.toJSONString(product);
        System.out.println("转换为json:" + JSONObject.toJSONString(product));

        jsonStr = jsonStr.toUpperCase();
        System.out.println(jsonStr);

        product = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Product.class);
        System.out.println(product.toString());
    }
}

// 转换为json:{"desc":"这是一个产品","name":"产品","price":"22.3"}
// {"DESC":"这是一个产品","NAME":"产品","PRICE":"22.3"}
// {"desc":"这是一个产品","name":"产品","price":"22.3"}

// 有了这个注解之后，我们在转换bean时，就不需要在手工方式，为不能转换的属性进行赋值。即使以后返回数据反生变化，
// 也能够快速的进行修改。不用修改大片代码。只需要修改注解name值就可以了。
