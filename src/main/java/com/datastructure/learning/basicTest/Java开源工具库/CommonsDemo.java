package com.datastructure.learning.basicTest.Java开源工具库;

/**
 * @author: lipan
 * @date: 2020/6/9
 * @description:
 */
public class CommonsDemo {

  /**
   * apache commons 官方地址：http://commons.apache.org/
   *
   * <p>这不是一个库，而是一系列的工具库。
   *
   * <p>由于包含的库过多，我就不一一列举了，可以到官网一探。有集合处理的、数学计算的、IO 操作的等等，其中最常用的莫过于 Apache Commons Lang 和 Apache
   * Commons Collections 这两个。
   *
   * <p>Apache Commons Lang 包括一系列工具类，有字符串相关的、时间处理的、反射的、并发包的等等，Apache Commons Collections 专门用作集合处理。
   *
   * <p>下面举几个例子说明一下，更详细的内容可以到官网查看文档。
   *
   * <p>字符串判空操作 String s = ""; Boolean isEmpty = StringUtils.isEmpty(s); 获取类的全名称
   * ClassUtils.getName(ClassUtils.class); 判断集合是否为空 Boolean isNotEmpty =
   * CollectionUtils.isNotEmpty(list); 反射获取某个类的所有 Field Field[] fields =
   * FieldUtils.getAllFields(User.class);
   */
}
