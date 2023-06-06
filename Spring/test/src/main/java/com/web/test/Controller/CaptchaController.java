package com.web.test.Controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/captcha")
    public void showCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成验证码文本
        String captchaText = defaultKaptcha.createText();

        // 将验证码文本存储在会话中，以供后续验证
        request.getSession().setAttribute("captcha", captchaText);

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
