package com.web.test.Controller;

import com.web.test.DO.*;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/admin-api/grade3/")
public class Grade3Controller {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @CrossOrigin
    @GetMapping("/getTablestudent_service")
    public CommonResult<?> getTableStudent_Service() {
        StudentLeadership[] studentLeaderships = userMapper.getAllStudentLeadership();
        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[studentLeaderships.length];
        for (int i = 0; i < studentLeaderships.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(studentLeaderships[i].getStudentId());
            teacherGradeVOS[i].setContent(studentLeaderships[i].getStudentLeadershipContent());
        }

        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);


    }

    @PostMapping ("/setTablestudent_service")
    public CommonResult<String> setTablestudent_service(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            GradeSummary gradeSummary=userMapper.findByStudentId(teacherGradeVOS[i].getIndex());
            if (gradeSummary==null){
                logger.info("there should be a gradeSummary");
                continue;
            }
            gradeSummary.setStudentLeadershipGrade(teacherGradeVOS[i].getGrade());
            userMapper.updateStudentLeadershipGrade(gradeSummary);
        }
        // 返回 CommonResult
        logger.info("ok");
        return CommonResult.success("ok");
    }


}





