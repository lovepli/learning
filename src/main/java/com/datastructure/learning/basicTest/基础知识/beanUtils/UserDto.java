package com.datastructure.learning.basicTest.基础知识.beanUtils;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-12-10
 * @description:
 */
public class UserDto extends User{

    private Integer pId;

    private List<Long> menuIdList;

    private List<Long> actionIdList;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getActionIdList() {
        return actionIdList;
    }

    public void setActionIdList(List<Long> actionIdList) {
        this.actionIdList = actionIdList;
    }
}
