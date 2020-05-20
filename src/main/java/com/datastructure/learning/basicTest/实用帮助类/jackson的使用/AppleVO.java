package com.datastructure.learning.basicTest.实用帮助类.jackson的使用;

import lombok.Data;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:
 */
@Data
public class AppleVO {

    private Integer id;

    private Integer parentId;

    private String name;

    private List<Apple> children;

}
