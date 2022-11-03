package com.springway.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName week14-springboot-parent
 * @Author Lenovo
 * @Description TODO
 * @Date 2022/10/25 10:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class User {
    @ApiModelProperty("用户ID")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
}
