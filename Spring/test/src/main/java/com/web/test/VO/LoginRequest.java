package com.web.test.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户登录请求")
public class LoginRequest {
    @ApiModelProperty(value = "用户名", required = true,example = "user01")
    private String username;
    @ApiModelProperty(value = "密码", required = true,example = "123456")
    private String password;

    private  String captchaText;

}