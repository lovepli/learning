package com.datastructure.learning.basicTest.实用帮助类.其他javabean注解;

import com.datastructure.learning.basicTest.实用帮助类.其他javabean注解.validator.group.AddGroup;
import com.datastructure.learning.basicTest.实用帮助类.其他javabean注解.validator.group.UpdateGroup;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;  //validation注解的是使用
import java.util.Date;

/**
 * @author: lipan
 * @date: 2020/5/19
 * @description:  补充： @Version 该注释可用于在实体Bean中添加乐观锁支持
 * user对象与数据库表user一一对应
 * 参数校验(Validator)
 *
 * 这个类是 lenosp项目中使用的
 */
//@Table注解  作用是 ： 声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe)
@Table(name = "sys_user")
@Entity  //@Entity 可以写也可以不写
@Data
@ToString
public class SysUser {
    @Id
    @GeneratedValue  //主键自增长 唯一键，不能为null 长度限制20
    @Column(name = "id", unique = true, nullable = false, length = 20)
    private String id;// id主键

    @NotEmpty(message = "教师编号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String teacherNumber;//教师编号

    @NotEmpty(message = "密码不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String password;//登录密码

    @NotBlank(message = "用户名不能为空")
    @Column(name = "teacher_name" ,length=20)
    private String teacherName;//教师姓名

    @Email(message = "邮箱格式不正确")
    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;//性别

  /**
   * 可以将字符串日期转为Date 提供给后端
   * 当然后端也可以利用此注解将 dto 中的 Date 转给前端需要的字符串格式。
   * 源自org.springframework.format.annotation 是spring自己的帮助类
   * 注意区别与 @JsonFormat(pattern = "yyyy-MM-dd")这个注解，这个注解是jackson中的注解，即是json解析器的规范！！！！
   */
  @Column(name = "birthday")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  // @DateTimeFormat(pattern="HHmm")
  private Date birthday; // 出生日期
  /**
   *  @DateTimeFormat 和@JsonFormat 的使用场景：
   * 场景： @RequestBody 中的日期参数是 json 格式，可以用 @JsonFormat, 注意不能用 @DateTimeFormat，因为Spring已经把解析逻辑下发给
   * json处理器。但是如果前端用 @RequestParam，那就不是 json 形式而是类似 createdAt="2017-01-01" 这种 key-value 格式
   * ，Spring自己定义的注解 @DateTimeFormat 就派上用场了
   */
  @Column(name = "phone_number")
  private String phoneNumber; // 手机号码

    /**
     * 当POJO有属性不需要映射的时候一定要用@Transitent修饰，该注释表示此属性与表没有映射关系，只是一个暂时的属性。
     *
     * 这个注解就和jackson中的 @JsonIgnore的作用是一样的
     */
    @Transient
    private String dept;//所在部门

    @Column(name = "professor")
    private String professor;//职称

    @Column(name = "subject")
    private String subject;//任教科目

    @Column(name = "balance")
    private Integer balance;//余额

    @Column(name = "school_code")
    private String schoolCode;//所属学院编号

    @Column(name = "school_name")
    private String schoolName;//所属学院名称

    /**
     * 0可用1封禁
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    @Column(name = "standby1")
    private Integer standby1;//备用字段1

    @Column(name = "standby2")
    private String standby2;//备用字段2

}
