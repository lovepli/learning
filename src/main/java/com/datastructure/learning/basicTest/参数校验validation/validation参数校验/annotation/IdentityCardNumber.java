package com.datastructure.learning.basicTest.参数校验validation.validation参数校验.annotation;
import com.datastructure.learning.basicTest.参数校验validation.validation参数校验.valid.IdentityCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: colin
 * @Date: 2019/12/24 20:15
 * @Description: 自定义参数注解
 * @Version: V1.0
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface IdentityCardNumber {

    String message() default "身份证号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
