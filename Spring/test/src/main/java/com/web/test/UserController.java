package com.web.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-api/user/")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/profile/get")
    public CommonResult<?> getUserProfile(@RequestHeader("Authorization") String authHeader) {

        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        User foundUser = userMapper.findByUsername(username);
        CommonResult<User> result = CommonResult.success(foundUser);
        logger.info(foundUser.getName());
        return result;
    }

    @PostMapping("/profile/changeinfo")
    public CommonResult<?> login(@RequestHeader("Authorization") String authHeader,@RequestBody User user) {

        CommonResult<User> result;
        logger.info(user.getUsername());
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        User foundUser = userMapper.findByUsername(username);
        if (username.equals(user.getUsername())){
            logger.info(username);
            userMapper.changeinfo(user);
            logger.info("new "+user.getName());
            result = CommonResult.success(foundUser);
        }else {
            result=CommonResult.error(50007,"不能修改他人信息");
        }
        return result;
    }

    @PostMapping("/profile/changepass")
    public CommonResult<?> login(@RequestHeader("Authorization") String authHeader,@RequestBody Userpass userpass) {
        CommonResult<User> result;
        logger.info("Hiii");

        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User foundUser = userMapper.findByUsername(username);
        logger.info(username);
        logger.info(foundUser.getUsername());
        logger.info(foundUser.getPassword());
        if (username.equals(userpass.getUsername())){
            if (foundUser.getPassword().equals(userpass.getOldpassword())){
                userMapper.changepass(userpass);
                result = CommonResult.success(foundUser);
            }else {
                result=CommonResult.error(50006,"密码错误");
            }
        }else {
            result=CommonResult.error(50007,"不能修改他人信息");
        }
        return result;
    }



}
