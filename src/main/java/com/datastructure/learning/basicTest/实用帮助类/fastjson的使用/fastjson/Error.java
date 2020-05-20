package com.datastructure.learning.basicTest.实用帮助类.fastjson的使用.fastjson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:
 */
public class Error implements Serializable {

    private static final long serialVersionUID = -432908543160176349L;

    private String code;
    private String message;
    private String success;
    private List<Data> data = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
