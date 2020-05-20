package com.datastructure.learning.json.fastjson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

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

