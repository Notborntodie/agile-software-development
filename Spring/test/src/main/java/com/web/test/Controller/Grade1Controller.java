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

@RequestMapping("/admin-api/grade1/")
public class Grade1Controller {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @CrossOrigin       //后端跨域
    @GetMapping("/getTablepersonal_summary")
    public CommonResult<?> getTablepersonal_summary() {
        PersonalSummary[] personalSummaries = userMapper.getAllPersonalSummary();
        //logger.info(personalSummaries[0].getPersonalSummaryContent(),personalSummaries.length);
        logger.info("czyczy");

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[personalSummaries.length];
        for (int i = 0; i < personalSummaries.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(personalSummaries[i].getStudentId());
            teacherGradeVOS[i].setContent(personalSummaries[i].getPersonalSummaryContent());
        }

        // 返回 CommonResult
        logger.info("czyczyczy");
        return CommonResult.success(teacherGradeVOS);
    }

    @PostMapping ("/setTablepersonal_summary")
    public CommonResult<String> setTablepersonal_summary(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            GradeSummary gradeSummary=userMapper.findByStudentId(teacherGradeVOS[i].getIndex());
            if (gradeSummary==null){
                logger.info("there should be a gradeSummary");
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





