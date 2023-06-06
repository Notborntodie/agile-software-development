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

@RequestMapping("/admin-api/grade4/")
public class Grade4Controller {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @CrossOrigin
    @GetMapping("/getTablesocial_practice")
    public CommonResult<?> getTableSocialPractice() {
        SocialPractice[] socialPractices = userMapper.getAllSocialPractice();

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[socialPractices.length];
        for (int i = 0; i < socialPractices.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(socialPractices[i].getStudentId());
            teacherGradeVOS[i].setContent(socialPractices[i].getSocialPracticeContent());
        }

        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);
    }




    @PostMapping ("/setTablesocial_practice")
    public CommonResult<String> setTablesocial_practice(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            GradeSummary gradeSummary=userMapper.findByStudentId(teacherGradeVOS[i].getIndex());
            if (gradeSummary==null){
                logger.info("there should be a gradeSummary");
                continue;
            }
            gradeSummary.setSocialPracticeGrade(teacherGradeVOS[i].getGrade());
            userMapper.updatesocialPracticeGrade(gradeSummary);
        }
        // 返回 CommonResult
        logger.info("ok");
        return CommonResult.success("ok");
    }


}





