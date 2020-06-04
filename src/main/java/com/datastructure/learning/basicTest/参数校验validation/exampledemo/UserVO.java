package com.datastructure.learning.basicTest.参数校验validation.exampledemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private String username;
    private String mobile;
    private String sex;

}
