package com.skycloud.service.member.api.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author
 */
@Data
public class MemberPwdUpdateDto {

    @ApiModelProperty("旧密码")
    @NotEmpty(message = "旧密码不能为空，请输入旧密码!")
    private String oldPassword;

    @NotEmpty(message = "新密码不能为空，请输入新密码!")
    @ApiModelProperty("新密码")
    private String newPassword;

}
