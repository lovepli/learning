package com.datastructure.learning.basicTest.实用帮助类.fastjson的使用.jsonfield的使用;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description: 案例： 最近做项目中，使用了json格式在服务器之间进行数据传输。但是发现json格式数据不符合JAVA中的变量定义规则，并且难以理解，
 *     因此需要在后台中做二次处理，将数据处理成我们系统中定义的格式。 思路： 1. 定义需要返回的bean,bean中定义需要返回的数据 2. 获取到需要处理的JSON字符串 3.
 *     将JSON字符串转换为bean, 再将转换后的bean返回给客户端。
 */

/**
 * @JSONField的作用对象:
 *
 *  1. Field
 *  2. Setter 和 Getter方法
 *  注：FastJson在进行操作时，是根据getter和setter的方法进行的，并不是依据Field进行。
 */
// 由于json中的key与bean中的属性不能匹配，因此在转换过程中出现了部分属性为null的情况。经过查看官方文档，
// 发现可以使用@JSONField进行解释，但是并没有详细的使用说明。
public class Person {

    /**
     * @JSONField 作用在Field时，其name不仅定义了输入key的名称，同时也定义了输出的名称。
     */
    @JSONField(name="name")
    private String name;

    @JSONField(name="age")
    private String age;

    @JSONField(name="desc")
    private String desc;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNAME(String NAME) {
        this.name = NAME;
    }

    public void setAGE(String AGE) {
        this.age = AGE;
    }

    public void setDESC(String DESC) {
        this.desc = DESC;
    }

    //直接返回json字符串
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
