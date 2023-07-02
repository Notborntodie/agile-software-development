
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

@RequestMapping("/admin-api/grade2/")
public class Grade2Controller {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());




    @CrossOrigin       //后端跨域
    @GetMapping("/getTableresearch_status")
    public CommonResult<?> getTableresearch_status() {

        Research[] research=userMapper.getAllResearch();

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[research.length];
        for (int i = 0; i < research.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(research[i].getStudentId());
            teacherGradeVOS[i].setContent(research[i].getResearchContent());
        }
        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);
    }



    @PostMapping ("/setTableresearch_status")
    public CommonResult<String> setTableresearch_status(@RequestBody TeacherGradeVO[] teacherGradeVOS) {
        for (int i = 0; i < teacherGradeVOS.length; i++) {
            GradeSummary gradeSummary=userMapper.findByStudentId(teacherGradeVOS[i].getIndex());
            if (gradeSummary==null){
                logger.info("there should be a gradeSummary");
                continue;
            }
            gradeSummary.setResearchGrade(teacherGradeVOS[i].getGrade());
            userMapper.updateResearchGrade(gradeSummary);
        }
        // 返回 CommonResult
        logger.info("ok");
        return CommonResult.success("ok");
    }





}





