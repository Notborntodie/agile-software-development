package com.web.test;

import com.web.test.Mapper.RoleMapper;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Component
public class MyInterceptor implements HandlerInterceptor {


    private RoleMapper roleMapper;


    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    public MyInterceptor(RoleMapper roleMapper,JwtTokenUtil jwtTokenUtil) {
        this.roleMapper = roleMapper;this.jwtTokenUtil= jwtTokenUtil;
    }




    public boolean isUrlMatched(List<String> urls, String url) {
        for (String u : urls) {
            logger.info(u);
            if (url.startsWith(u)) {
                return true;
            }
        }
        return false;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行的操作
        System.out.println("=====preHandle=====");

        String authHeader=request.getHeader( "Authorization");
        if (authHeader==null){

            //return true;

            String url = request.getRequestURI();
            if (url.startsWith("/admin-api/auth")){
                return  true;
            }else{
                return  false;
            }

        }


        String token = authHeader.substring(7);
        System.out.println("Token");
        System.out.println(token);



        String username = jwtTokenUtil.getUsernameFromToken(token);
        String url = request.getRequestURI();
        System.out.println(url);
        System.out.println(username);
        List<String> urls= roleMapper.findUrls(username);

        if (!isUrlMatched(urls,url)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("You do not have the necessary permissions to access this resource.");
            return false;
        } else {
            // 对于所有其他的请求，继续处理
            //response.getWriter().write("OK");
            //return  false;
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 在请求处理之后，视图渲染之前执行的操作
        System.out.println("=====postHandle=====");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 在请求完成之后执行的操作，即视图渲染完成后
        System.out.println("=====afterCompletion=====");
    }
}

