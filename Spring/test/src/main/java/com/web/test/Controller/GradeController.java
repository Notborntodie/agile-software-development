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
        //logger.info(personalSummaries[0].getPersonalSummaryContent(),personalSummaries.length);

        TeacherGradeVO[] teacherGradeVOS = new TeacherGradeVO[personalSummaries.length];
        for (int i = 0; i < personalSummaries.length; i++) {
            teacherGradeVOS[i] = new TeacherGradeVO();
            teacherGradeVOS[i].setIndex(personalSummaries[i].getStudentId());
            teacherGradeVOS[i].setContent(personalSummaries[i].getPersonalSummaryContent());
        }

        // 返回 CommonResult
        return CommonResult.success(teacherGradeVOS);
    }

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





