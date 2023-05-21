package com.web.test.Controller;

import com.web.test.DO.User;
import com.web.test.DO.UserDemo;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.CommonResult;
import com.web.test.VO.LoginRequest;
import com.web.test.VO.RegisterRequest;
import com.web.test.VO.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-api/auth")
public class AuthController {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @CrossOrigin       //后端跨域
    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginRequest loginUser) {

        User user=userMapper.getUser(loginUser.getUsername());
        logger.info(loginUser.getUsername());
        if (user == null) {
            return CommonResult.error(50007,"登录失败，用户不正确");
        }

        logger.info(user.getPassword());

        if (!loginUser.getPassword().equals(user.getPassword())) {
            return CommonResult.error(50007,"登录失败，密码不正确");
        }

        String username = loginUser.getUsername();

        // 生成访问令牌和刷新令牌
        String accessToken = jwtTokenUtil.generateAccessToken(username);

        String refreshToken = jwtTokenUtil.generateRefreshToken(username);
        logger.info(accessToken);
        TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);
        return  CommonResult.success(token_resp);
    }



}

