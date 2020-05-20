package com.datastructure.learning.basicTest.实用帮助类.fastjson的使用;

import cn.hutool.json.JSONUtil;
import com.datastructure.learning.basicTest.实用帮助类.树结构转换.Menu2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:
 */
public class JsonUtilBean {

    public  static  void fun(){
        List<Menu2> menuList = new ArrayList<>();
        menuList.add(new Menu2(1, null, "节点1"));
        menuList.add(new Menu2(2, null, "节点2"));
        menuList.add(new Menu2(3, 1, "节点1.1"));
        menuList.add(new Menu2(4, 1, "节点1.2"));
        menuList.add(new Menu2(5, 3, "节点1.1.1"));
        //菜单集合为：
        //这里使用了工具类将对象转换为json字符串
        System.out.println(JSONUtil.toJsonStr(menuList));
//        //这里的JSONutil.toJsonStr();是用的github上的一个工具类，也可以用fastjson工具类
//        JSONObject returnValue = new JSONObject();
//        returnValue.put("menuList", "hello world");
//        System.out.println(JSON.toJSONString(returnValue));
    }

  public static void main(String[] args) {
    fun();
  }
}
