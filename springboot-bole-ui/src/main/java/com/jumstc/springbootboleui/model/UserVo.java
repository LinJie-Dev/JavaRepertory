package com.jumstc.springbootboleui.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname UserVo
 * @Description TODO
 * @Date 2020/6/4 16:07
 * @Auther 林杰
 */
@ApiModel(value = "用户实体")
@Data
public class UserVo implements Serializable {
    @ApiModelProperty(value = "id", hidden = true)
    private Long id;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
