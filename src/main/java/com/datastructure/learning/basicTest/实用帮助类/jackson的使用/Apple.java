package com.datastructure.learning.basicTest.实用帮助类.jackson的使用;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020/5/20
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"createBy"})
public class Apple implements Serializable {
    private static final long serialVersionUID = 5561561457068906366L;
    /**
     * 返回json数据为id
     */
    @JsonProperty("id")
    private Integer appleId;

    @JsonProperty("pid")
    private Integer parentId;

    @JsonProperty("name")
    private String appleName;

    private String url;

    @JsonIgnore
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String address ;

    private String createBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String checkArr ;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Apple> children;


}
