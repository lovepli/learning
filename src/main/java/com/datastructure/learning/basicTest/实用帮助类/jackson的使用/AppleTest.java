package com.datastructure.learning.basicTest.实用帮助类.jackson的使用;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:
 */
public class AppleTest {
    public static void main(String[] args)  {
        Apple apple=new Apple(1,0,"apple","/test", "1171205514@qq.com","深圳" ,"2020-05-20","a",null);

        ObjectMapper mapper = new ObjectMapper();
        // java对象转换为json字符换
        String Json = null;
        try {
            Json = mapper.writeValueAsString(apple);
            System.out.println(Json);
            //{"url":"/test","address":"深圳","checkArr":"a","id":1,"pid":0,"name":"apple"}
            // json字符串转换为java对象
            Apple apple2 = mapper.readValue(Json, Apple.class);
            System.out.println(apple2);
            //Apple(appleId=1, parentId=0, appleName=apple, url=/test, email=null, address=深圳, createBy=null, checkArr=a, children=null)
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        AppleVO appleVO=new AppleVO();

        BeanUtils.copyProperties(apple, appleVO);
        System.out.println(appleVO);
        //AppleVO(id=null, parentId=0, name=null, children=null)
        //属性名相同的才能复制
        AppleVO2 appleVO2=new AppleVO2();
        BeanUtils.copyProperties(apple, appleVO2);
        System.out.println(appleVO2);
    }
}
