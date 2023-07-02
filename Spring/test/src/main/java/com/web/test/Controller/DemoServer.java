package com.web.test.Controller;


import com.web.test.Service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "演示接口")
@RestController
@RequestMapping("/my-api/demo")
public class DemoServer {
    RedisService redisService;
    @ApiOperation("Hello World接口")
    @GetMapping("/hello")
    public String hello() {
        redisService.setValue("ab","1112");
        redisService.setValueWithExpiration("abcd","1112",10);
        redisService.deleteValue("abc");
        System.out.println(redisService.getValue("ab"));
        return redisService.getValue("ab");
    }
}