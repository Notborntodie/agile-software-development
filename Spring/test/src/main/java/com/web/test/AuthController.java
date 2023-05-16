package com.web.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-api/auth")
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public CommonResult<?> register(@RequestBody RegisterRequest reg_user) {

        User foundUser = userMapper.findByUsername(reg_user.getIdCard());

        if (foundUser != null) {
            return CommonResult.error(50003,"用户已存在");
        }

        User new_user = new User(reg_user.getIdCard(),reg_user.getPassword()
                ,reg_user.getName(),reg_user.getIdCard(),reg_user.getPhone()
                ,reg_user.getEmail());

        logger.info(reg_user.getName());
        try {
            // 将用户信息保存到数据库
            userMapper.insert(new_user);
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
    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginRequest loginUser) {

        User user = userMapper.findByUsername(loginUser.getUsername());

        if (user == null) {
            return CommonResult.error(50007,"登录失败，账号密码不正确");
        }

        if (!loginUser.getPassword().equals(user.getPassword())) {
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