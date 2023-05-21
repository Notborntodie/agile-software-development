package com.web.test.Controller;


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
/*
@RestController
//@RequestMapping("/admin-api/auth")
public class AuthControllerDemo {

    @Autowired
    private UserMapper userMapper;

    //@PostMapping("/register")
    public CommonResult<?> register(@RequestBody RegisterRequest reg_user) {

        UserDemo foundUserDemo = userMapper.findByUsername(reg_user.getIdCard());

        if (foundUserDemo != null) {
            return CommonResult.error(50003,"用户已存在");
        }

        UserDemo new_userDemo = new UserDemo(reg_user.getIdCard(),reg_user.getPassword()
                ,reg_user.getName(),reg_user.getIdCard(),reg_user.getPhone()
                ,reg_user.getEmail());

        logger.info(reg_user.getName());
        try {
            // 将用户信息保存到数据库
            userMapper.insert(new_userDemo);
        } catch (Exception e) {
            // 处理插入失败的情况
            System.out.println(e.toString());
            return CommonResult.error(50003,"User registration failed");
        }
        return CommonResult.success("User registered successfully");
    }




    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @CrossOrigin       //后端跨域
    //@PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginRequest loginUser) {

        UserDemo userDemo = userMapper.findByUsername(loginUser.getUsername());

        if (userDemo == null) {
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }

        if (!loginUser.getPassword().equals(userDemo.getPassword())) {
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }

        String username = loginUser.getUsername();

        // 生成访问令牌和刷新令牌
        String accessToken = jwtTokenUtil.generateAccessToken(username);

        String refreshToken = jwtTokenUtil.generateRefreshToken(username);
        logger.info(accessToken);
        TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);
        CommonResult<TokenResponse> result = CommonResult.success(token_resp);

        return result;
    }


}
*/