package com.web.test.Controller;

import com.web.test.DO.UserDemo;
import com.web.test.VO.CommonResult;
import com.web.test.Mapper.UserMapper;
import com.web.test.VO.Userpass;
import com.web.test.Util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
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
        UserDemo foundUserDemo = userMapper.findByUsername(username);
        CommonResult<UserDemo> result = CommonResult.success(foundUserDemo);
        logger.info(foundUserDemo.getName());
        return result;
    }

    @PostMapping("/profile/changeinfo")
    public CommonResult<?> login(@RequestHeader("Authorization") String authHeader,@RequestBody UserDemo userDemo) {

        CommonResult<UserDemo> result;
        logger.info(userDemo.getUsername());
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        UserDemo foundUserDemo = userMapper.findByUsername(username);
        if (username.equals(userDemo.getUsername())){
            logger.info(username);
            userMapper.changeinfo(userDemo);
            logger.info("new "+ userDemo.getName());
            result = CommonResult.success(foundUserDemo);
        }else {
            result=CommonResult.error(50007,"不能修改他人信息");
        }
        return result;
    }

    @PostMapping("/profile/changepass")
    public CommonResult<?> login(@RequestHeader("Authorization") String authHeader,@RequestBody Userpass userpass) {
        CommonResult<UserDemo> result;
        logger.info("Hiii");

        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserDemo foundUserDemo = userMapper.findByUsername(username);
        logger.info(username);
        logger.info(foundUserDemo.getUsername());
        logger.info(foundUserDemo.getPassword());
        if (username.equals(userpass.getUsername())){
            if (foundUserDemo.getPassword().equals(userpass.getOldpassword())){
                userMapper.changepass(userpass);
                result = CommonResult.success(foundUserDemo);
            }else {
                result=CommonResult.error(50006,"密码错误");
            }
        }else {
            result=CommonResult.error(50007,"不能修改他人信息");
        }
        return result;
    }



}

*/

