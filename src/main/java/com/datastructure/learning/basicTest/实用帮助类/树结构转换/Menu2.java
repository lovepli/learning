package com.datastructure.learning.basicTest.实用帮助类.树结构转换;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/14
 * @description:
 */
@Data
public class Menu2 implements Serializable {
    private static final long serialVersionUID = 5561561457068906366L;

    private Integer menuId;

    private Integer parentId;

    private String menuName;

    private String url;

    private List<Menu2> children;

    public Menu2(){}

    public Menu2(Integer menuId, Integer parentId, String menuName) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.menuName = menuName;
    }
}