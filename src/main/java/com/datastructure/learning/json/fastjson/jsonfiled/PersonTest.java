package com.datastructure.learning.json.fastjson.jsonfiled;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:  测试类 参考：https://blog.csdn.net/u011425751/article/details/51219242
 */
public class PersonTest {

    private  Person person;

    /**
     * 初始化对象
     */
     {
        person = new Person();
        person.setName("xianglj");
        person.setAge("20");
        person.setDesc("只是一个测试");
    }


    public void test() {
        String jsonStr = JSONObject.toJSONString(person);
        System.out.println("bean to json:" + jsonStr);

        //改变json的key为大写
        jsonStr = jsonStr.toUpperCase();

        System.out.println("需要转换的json:" + jsonStr);
        person = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Person.class);
        System.out.println("json to bean:" + person.getName());

    }

  public static void main(String[] args) {
     new  PersonTest().test();
    // 输出
    // bean to json:{"age":"20","desc":"只是一个测试","name":"xianglj"}
    // 需要转换的json:{"AGE":"20","DESC":"只是一个测试","NAME":"XIANGLJ"}
    // json to bean:null
    // 从上面我们可以看出，当@JSONField作用在Fileld上时，定义了输入和输出，如果我们传输过来的json格式不符合这个格式时，则不能够正确转换。
  }
}

