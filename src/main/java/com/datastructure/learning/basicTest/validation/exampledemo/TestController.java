package com.datastructure.learning.basicTest.validation.exampledemo;

import com.datastructure.learning.basicTest.validation.validation参数校验.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:  不用valaitor校验框架，必须要手写校验逻辑，代码复杂冗余
 */
@RestController
@RequestMapping("user/")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    /**
     * 走串行校验
     *
     * @param
     * @return
     */
    @PostMapping("/save/serial")
    public Object save(/** @RequestBody UserVO userVO */) {

       // UserVO userVO=new UserVO("","17777777","");
       // UserVO userVO=new UserVO("张三","17777777","");
        UserVO userVO=new UserVO("张三","17671226463","");

        //抛出自定义异常等~写法
        if (StringUtils.isBlank(userVO.getUsername())) {
            //因为自定义了全局异常处理，在全局异常处理里面，输出了log。error日志，所以在这里就不需要输出了写log.info("")
           // log.info("用户名不能为空");
            throw new BizException(Constant.PARAM_FAIL_CODE, "用户名不能为空");
        }

        String mobile = userVO.getMobile();
        //手动逐个 参数校验~ 写法
        if (StringUtils.isBlank(mobile)) {
          log.info("手机号码不能为空");
          //这里返回的结果是返回给前端的错误结果，不会在日志里面纪录下来这个错误！！！所以最好使用抛出自定义异常，这样既能在控制台抛出异常纪录，又能返回给页面错误信息
            return RspDTO.paramFail("mobile:手机号码不能为空");
            //使用正则表达式来进行校验
        } else if (!Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile)) {
            log.info("手机号码格式不对");
            return RspDTO.paramFail("mobile:手机号码格式不对");
        }

        // 比如写一个map返回   这样的写法也只能是返回给前端页面，不能将错误信息打印到控制台！！，所以还是要自定义错误异常抛出
        if (StringUtils.isBlank(userVO.getSex())) {
            Map<String, Object> result = new HashMap<>(5);
            result.put("code", Constant.PARAM_FAIL_CODE);
            result.put("msg", "性别不能为空");
            log.info("性别不能为空");
            return result;
        }
        //.........各种写法 ...
       // userService.save(userVO);
        return RspDTO.success();
    }

}
