package com.web.test.Controller;

import com.web.test.DO.GradeSummary;
import com.web.test.DO.Student;
import com.web.test.DO.UserDemo;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.CommonResult;
import com.web.test.VO.StudentEvaluateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin-api/student/")
public class StudentController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping ("/getEvainfo")
    public CommonResult<StudentEvaluateVO> getEvainfo(@RequestHeader("Authorization") String authHeader) {

        StudentEvaluateVO studentEvaluateVO=new StudentEvaluateVO();
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student= userMapper.findByUsername(username);
        studentEvaluateVO.setName(student.getName());
        studentEvaluateVO.setStudentNumber(student.getStudentNumber());
        GradeSummary gradeSummary=userMapper.findByStudentId(student.getId());
        studentEvaluateVO.setAcademicGrade(gradeSummary.getAcademicGrade());
        logger.info(studentEvaluateVO.getName());
        return  CommonResult.success(studentEvaluateVO);
    }



    @PostMapping ("/changeEvainfo")
    public CommonResult<?> changeEvainfo(@RequestHeader("Authorization") String authHeader ,
                                                      @RequestBody StudentEvaluateVO studentEvaluateVO) {

        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student= userMapper.findByUsername(username);



        return CommonResult.success("ok");
    }

}



