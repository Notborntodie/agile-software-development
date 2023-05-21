package com.web.test.Controller;

import com.web.test.DO.GradeSummary;
import com.web.test.DO.PersonalSummary;
import com.web.test.DO.Student;
import com.web.test.DO.User;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/admin-api/grade/")
public class GradeController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @CrossOrigin       //后端跨域
    @GetMapping("/getTablepersonal_summary")
    public CommonResult<?> getTablepersonal_summary() {
        PersonalSummary[] personalSummaries = userMapper.getAllPersonalSummary();
        logger.info(personalSummaries[0].getPersonalSummaryContent(),personalSummaries.length);

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[personalSummaries.length];
        for (int i = 0; i < personalSummaries.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(i);
            teacherGradeVOS[i].setContent(personalSummaries[i].getPersonalSummaryContent());
        }

        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);

    }


    @PostMapping ("/setTablepersonal_summary")
    public CommonResult<String> setTablepersonal_summary(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            PersonalSummary personalSummary=userMapper.findByPersonalSummaryContent(teacherGradeVOS[i].getContent());
            if (personalSummary==null){
                continue;
            }
            GradeSummary gradeSummary=userMapper.findByStudentId(personalSummary.getStudentId());
            if (gradeSummary==null){
                //logger.info("there should be a gradeSummary");
                continue;
            }
            gradeSummary.setPersonalSummaryGrade(teacherGradeVOS[i].getGrade());
            userMapper.updatePersonalSummaryGrade(gradeSummary);
        }
        // 返回 CommonResult
        logger.info("ok");
        return CommonResult.success("ok");

    }

}





