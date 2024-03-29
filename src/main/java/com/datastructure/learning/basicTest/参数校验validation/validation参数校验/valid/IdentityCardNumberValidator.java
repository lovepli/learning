package com.datastructure.learning.basicTest.参数校验validation.validation参数校验.valid;

import com.datastructure.learning.basicTest.参数校验validation.validation参数校验.annotation.IdentityCardNumber;
import com.datastructure.learning.basicTest.参数校验validation.validation参数校验.utils.IdCardValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @项目名称：springboot
 * @包名：com.zhliang.springboot.validator.valid
 * @类描述：验证类
 * @创建人：colin
 * @创建时间：2019/12/24 20:16
 * @version：V1.0
 */
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object> {

    @Override
    public void initialize(IdentityCardNumber identityCardNumber) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return IdCardValidatorUtil.isValidate18Idcard(o.toString());
    }
}
