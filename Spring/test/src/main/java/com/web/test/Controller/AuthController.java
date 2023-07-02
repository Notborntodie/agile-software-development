package com.web.test.Controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.web.test.DO.User;
import com.web.test.DO.Menu;
import com.web.test.DO.UserDemo;
import com.web.test.Mapper.RoleMapper;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@RestController
@RequestMapping("/admin-api/auth")
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @CrossOrigin       //后端跨域
    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginRequest loginUser,HttpServletRequest request) {

        User user=userMapper.getUser(loginUser.getUsername());
        logger.info(loginUser.getUsername());
        if (user == null) {
            return CommonResult.error(50007,"登录失败，用户不正确");
        }

        logger.info(user.getPassword());

        if (!loginUser.getPassword().equals(user.getPassword())) {
            return CommonResult.error(50007,"登录失败，密码不正确");
        }

        String captchaText= loginUser.getCaptchaText();
        String storedCaptcha = (String) request.getSession().getAttribute("captcha");
        System.out.println(captchaText);
        System.out.println(storedCaptcha);
        request.getSession().removeAttribute("captcha"); // 删除会话中的验证码

        if (!captchaText.equalsIgnoreCase(storedCaptcha)){
            return CommonResult.error(50007,"登录失败，验证码不正确");
        }

        String username = loginUser.getUsername();

        // 生成访问令牌和刷新令牌
        String accessToken = jwtTokenUtil.generateAccessToken(username);

        String refreshToken = jwtTokenUtil.generateRefreshToken(username);
        logger.info(accessToken);
        TokenResponse token_resp = new TokenResponse(accessToken,refreshToken);
        return  CommonResult.success(token_resp);
    }
    @CrossOrigin
    @GetMapping("/menu")
    public CommonResult<?> getMenuList(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Menu[] menuList = roleMapper.getMenu(username);

        LinkedHashSet<Menu> menuSet = new LinkedHashSet<>(Arrays.asList(menuList));

// 如果需要返回Menu[]类型，将LinkedHashSet转换回数组
        Menu[] uniqueMenuList = menuSet.toArray(new Menu[0]);



        System.out.println("okkkk");
        for (int i=0;i<uniqueMenuList.length;i++){
            System.out.println(uniqueMenuList[i].getName());
            System.out.println(uniqueMenuList[i].getPath());
            System.out.println(uniqueMenuList[i].getComponent());
        }
        return CommonResult.success(uniqueMenuList);
    }


    @CrossOrigin
    @PostMapping("/changepass")
    public CommonResult<?>  changepass(@RequestHeader("Authorization") String authHeader, @RequestBody ChangPassVO changPassVO){
        StudentEvaluateVO studentEvaluateVO=new StudentEvaluateVO();
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user=userMapper.getUser(username);
        if (user == null) {
            CommonResult.error(50006,"用户不正确");
        }

        if (!user.getPassword().equals(changPassVO.getOldpassword())){
            CommonResult.error(50007,"密码不正确");
        }

        user.setPassword(changPassVO.getNewpassword());
        userMapper.changepass(user);

        return CommonResult.success("ok");
    }



    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @CrossOrigin
    @GetMapping("/captcha")
    public void showCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码文本
        String captchaText = defaultKaptcha.createText();

        // 将验证码文本存储在会话中，以供后续验证
        request.getSession().setAttribute("captcha", captchaText);
        System.out.println((String) request.getSession().getAttribute("captcha"));

        // 生成验证码图片
        BufferedImage captchaImage = defaultKaptcha.createImage(captchaText);

        // 将验证码图片写入响应
        response.setContentType("image/png");
        try (OutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(captchaImage, "png", outputStream);
            outputStream.flush();
        }
    }


}

