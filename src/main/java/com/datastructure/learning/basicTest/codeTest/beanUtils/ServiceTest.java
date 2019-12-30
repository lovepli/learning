package com.datastructure.learning.basicTest.codeTest.beanUtils;

import org.springframework.beans.BeanUtils;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:  BeanUtils.copyProperties()的使用
 */
public class ServiceTest {

//以前属性赋值的写法是这样的：
//    // 逐一赋值
//userDto.setUsername(user.getUsername);
//
//userDto.setPassword(user.getPassword);
//
//userDto.setAge(user.getAge);
//.........
//.........

    //伪代码
//    public boolean add(UserDto userDto){
//        User user=new User();
//        BeanUtils.copyProperties(userDto, user); //第一个参数是转换后的类，第二个参数是待转换的类
//        return userDao.insert(user) == 1;
//    }

    public static void add(UserDto userDto){
        User user=new User();
        BeanUtils.copyProperties(userDto, user); //第一个参数是转换后的类，第二个参数是待转换的类 即将userDto里面与user属性名相同的属性值拷贝到user
        System.out.println(user);
    }

    public static void main(String[] args) {
        UserDto userDto=new UserDto();
        userDto.setId(1l);
        userDto.setAge(2);
        userDto.setName("哈哈");
        userDto.setpId(3);  //userDto的属性多些

        add(userDto);
    }
}
