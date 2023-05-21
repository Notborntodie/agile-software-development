package com.web.test.Controller;


import com.web.test.VO.CommonResult;
import com.web.test.DO.UserDemo;
import com.web.test.Mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public CommonResult<?> Hello(){
        System.out.println("This is a system.out message");
        logger.info("This is an info log message");
        UserDemo foundUserDemo = userMapper.findByUsername("Bob");

        if (foundUserDemo == null) {
            return CommonResult.success("用户不存在");
        }
        return CommonResult.success(foundUserDemo.getPassword());
    }
}


 */
