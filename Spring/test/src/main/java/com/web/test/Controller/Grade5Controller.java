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

@RequestMapping("/admin-api/grade5/")
public class Grade5Controller {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());



    @CrossOrigin
    @GetMapping("/getTablevolunteer_service")
    public CommonResult<?> getTableVolunteerService() {
        VolunteerService[] volunteerServices = userMapper.getAllVolunteerService();

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[volunteerServices.length];
        for (int i = 0; i < volunteerServices.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(volunteerServices[i].getStudentId());
            teacherGradeVOS[i].setContent(volunteerServices[i].getVolunteerServiceContent());
        }

        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);
    }






    @PostMapping ("/setTablevolunteer_service")
    public CommonResult<String> setTablevolunteer_service(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            GradeSummary gradeSummary=userMapper.findByStudentId(teacherGradeVOS[i].getIndex());
            if (gradeSummary==null){
                logger.info("there should be a gradeSummary");
                continue;
            }
            gradeSummary.setVolunteerServiceGrade(teacherGradeVOS[i].getGrade());
            userMapper.updateVolunteerServiceGrade(gradeSummary);
        }
        // 返回 CommonResult
        logger.info("ok");
        return CommonResult.success("ok");
    }



}





