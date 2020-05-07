package com.datastructure.learning.basicTest.对象克隆.copyBean3;

import com.datastructure.learning.basicTest.对象克隆.copyBean1.Demo2;
import com.datastructure.learning.basicTest.对象克隆.copyBean1.DemoInternal2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: lipan
 * @date: 2020-03-04
 * @description: 深拷贝的实现方式3  ： BeanUtils.copyProperties()的使用
 */
public class BeanUtil {

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 非空拷贝
     * @param source
     * @param target
     */
    public static void copyNotNullBean(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    public static void main(String[] args) {

        DemoInternal2 di=new DemoInternal2();
        di.setInternalName("66");
        di.setInternalValue("77");

        Demo2 d1=new Demo2();
        d1.setName("哈哈");
        d1.setValue("呵呵");
        d1.setDemoInternal2(di);

        Demo2 d2= new Demo2();
        BeanUtil.copyNotNullBean(d1,d2); //TODO 深拷贝的实现 将对象d1的属性复制给对象d2
        System.out.println(d1==d2);//false  //TODO 两个对象
        System.out.println(d1);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}

        d2.setName("hhh");
        d2.setValue("hehehe");  //TODO 结论：改变克隆对象属性值，原对象属性值不变
        System.out.println(d1);//Demo{name='哈哈', value='呵呵', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='hhh', value='hehehe', demoInternal=DemoInternal{internalName='66', internalValue='77'}}

        d1.setName("ddddd");
        d1.setValue("bbbbb");   //TODO 结论：改变原对象属性值,克隆对象属性值不变
        System.out.println(d1);//Demo{name='ddddd', value='bbbbb', demoInternal=DemoInternal{internalName='66', internalValue='77'}}
        System.out.println(d2);//Demo{name='hhh', value='hehehe', demoInternal=DemoInternal{internalName='66', internalValue='77'}}





    }
}
