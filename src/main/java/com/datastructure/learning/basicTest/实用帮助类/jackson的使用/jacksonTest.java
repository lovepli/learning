package com.datastructure.learning.basicTest.实用帮助类.jackson的使用;

import org.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:
 */
public class jacksonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            /** json字符串转换为java对象 */

            // json中的对象个数比java对象的属性个数少
            JSONObject json1 = new JSONObject();
            json1.put("name", "anne");
            json1.put("age", 15);
            String d1 = json1.toString();
            Student s1 = mapper.readValue(d1, Student.class);
            System.out.println(s1.toString());

            // json中出现java对象中没有的属性
            JSONObject json2 = new JSONObject();
            json2.put("name", "anne");
            json2.put("age", 15);
            json2.put("sex", "boy");
            String d2 = json1.toString();
            Student s2 = mapper.readValue(d2, Student.class);
            System.out.println(s2.toString());

            /** java对象转换为json字符串 */
            Student s3 = new Student();
            s3.setAge(12);
            s3.setHobby("sport");
            s3.setName("anne");
            String d3 = mapper.writeValueAsString(s3);
            System.out.println(d3);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

}
@JsonIgnoreProperties(ignoreUnknown = true)
class Student {
    private String name;
    private int age;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String toString() {
        return "name: " + name + ", age: " + age + ", hobby: " + hobby;
    }
}

// 说明
// json字符串中的key应该与java对象的属性名相同
// java对象中属性如果为private，则需要显示生成getter/setter方法；如果属性为public，则可以不必写getter/setter方法
// java对象如果有自定义的构造方法，json字符串转换为java对象时会出错
// 如果json字符串中的属性个数小于java对象中的属性个数，可以顺利转换，java中多的那个属性为null
// 如果json字符串中出现java对象中没有的属性，则在将json转换为java对象时会报错：Unrecognized field, not marked as ignorable
// 解决方法：
// 在目标对象的类级别上添加注解：@JsonIgnoreProperties(ignoreUnknown = true)；如上述代码示例所示
// ————————————————
// 版权声明：本文为CSDN博主「黑色眼睛90」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/peach90/article/details/77875432
