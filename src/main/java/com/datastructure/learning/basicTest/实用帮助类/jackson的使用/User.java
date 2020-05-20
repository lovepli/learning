package com.datastructure.learning.basicTest.实用帮助类.jackson的使用;
import com.datastructure.learning.basicTest.实用帮助类.jackson的使用.groups.Create;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:  参考：https://blog.csdn.net/u012373815/article/details/52266609
 * user对象与数据库表user没有进行对应，没有使用@Table(name="")尽心对象关心映射绑定，注意区别这两种使用方式！！
 * 参数校验(Validator)
 * 这个在shiro-action项目中使用过
 * 注解的使用参考：https://blog.csdn.net/itguangit/article/details/78701110
 */
//1、生成json时将createBy和updateBy属性过滤
@Data
@JsonIgnoreProperties({"createBy","updateBy"}) //忽略这个两个属性
@JsonInclude(JsonInclude.Include.NON_NULL)  //User 的所有属性只有在不为 null 的时候才被转换成 json，如果为 null 就被忽略。并且如果password为空字符串也不会被转换.
@JsonIgnoreType   //标注在类上，当其他类有该类作为属性时，该属性将被忽略。
public class User {

    /**
     * 解决 json 键名称和 java pojo 字段名称不匹配的问题。
     */
    @JsonProperty("id")
    private int userId;

    @JsonProperty("name")
    @NotBlank(message = "用户名不能为空")
    private  String username;

    private int age;

    @NotBlank(message = "密码不能为空", groups = Create.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    @NotEmpty(message = "用户名不能为空")
    private String mobile;

    @JsonProperty("children")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<User> userList;



    /**
     * @JsonInclude(JsonInclude.Include.NON_NULL)表示,如果值为null,则不返回
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String checkArr = "0";

  /**
   * 2、生成json 时不生成email 属性 这个注解就和 @Transient 的作用一样， @Transient 注解是要求Java bean
   * 对象和数据库表一一对应的，注意区别
   *
   * @JsonIgnore 用来告诉 Jackson 在处理时忽略该注解标注的 java pojo 属性， 不管是将 java 对象转换成 json
   * 字符串，还是将 json 字符串转换成 java 对象。
   */
  @JsonIgnore
  @Email(message = "邮箱格式不正确")
  private String email;

  /**
   * 将后端的 Date 类型以特定格式的字符串返回给前端
   * 将前端 json 形式的字符串解析为 Date 类型
   * 源自 com.fasterxml.jackson.annotation
   *注意与 @DateTimeFormat(pattern = "yyyy-MM-dd”) 注解区别，这个注解来自 org.springframework.format.annotation
   */
  // 3、把Date类型直接转化为我们想要的模式
  @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
  private Date createBy;

    private Date updateBy;

    private String address;

  // 4、@JsonSerialize
  // 此注解用于属性或者getter方法上，用于在序列化时嵌入我们自定义的代码，比如序列化一个double时在其后面限制两位小数点。

  // 5、@JsonDeserialize
  // 此注解用于属性或者setter方法上，用于在反序列化时可以嵌入我们自定义的代码，类似于上面的@JsonSerialize

}
