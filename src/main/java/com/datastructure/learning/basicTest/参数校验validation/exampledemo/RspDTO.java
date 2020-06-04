package com.datastructure.learning.basicTest.参数校验validation.exampledemo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:
 */
@Data
@NoArgsConstructor
public class RspDTO<T> {

    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public RspDTO(int code,String message){
        this.code = code;
        this.message = message;
    }

    public RspDTO(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static RspDTO success() {
        return new RspDTO(200,"success");
    }


    public RspDTO success(T data) {
        return new RspDTO(200,"success",data);
    }

    public static RspDTO paramFail(String message) {
        return new RspDTO(500,message);
    }
}

