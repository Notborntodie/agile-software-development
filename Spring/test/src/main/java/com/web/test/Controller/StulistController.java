package com.web.test.Controller;

import com.web.test.DO.*;
import com.web.test.Mapper.RoleMapper;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.*;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/admin-api/stulist/")
public class StulistController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());






    @CrossOrigin       //后端跨域
    @PostMapping("/submit")
    public  CommonResult<String> submitStulist(@RequestBody StudentListVO studentListVO){
        List<StudentVO> studentVOs = studentListVO.getStudents();

        logger.info("ok1");

        for (StudentVO studentVO : studentVOs) {

            if (userMapper.getUser(studentVO.getId())==null) {
                User user=new User();
                user.setUsername(studentVO.getId());
                user.setPassword(studentVO.getId());
                userMapper.setUser(user);
                user = userMapper.getUser(studentVO.getId());

                roleMapper.setUserToStu(user.getId());

                Student student = new Student();
                student.setUserId(user.getId());
                student.setName(studentVO.getName());
                student.setStudentNumber(studentVO.getId());
                userMapper.setStudent(student);
                student = userMapper.getStudentByUid(student.getUserId());

                GradeSummary gradeSummary = new GradeSummary();
                gradeSummary.setStudentId(student.getId());
                gradeSummary.setAcademicGrade(studentVO.getGpa());
                userMapper.setGradeSummary(gradeSummary);
            }else{
                User user = userMapper.getUser(studentVO.getId());
                Student student = new Student();
                student.setUserId(user.getId());
                student.setName(studentVO.getName());
                userMapper.changeStudent(student);
                student = userMapper.getStudentByUid(student.getUserId());

                GradeSummary gradeSummary = new GradeSummary();
                gradeSummary.setStudentId(student.getId());
                gradeSummary.setAcademicGrade(studentVO.getGpa());
                userMapper.changeGpa(gradeSummary);

            }


        }

        // 返回 CommonResult
        return  CommonResult.success("ok");

    }


    @CrossOrigin       //后端跨域
    @GetMapping("/get")
    public  CommonResult<?> getStulist(){
        GradeSummary[] gradeSummaries=userMapper.getAllGrade();
        EvaluateVO[] evaluateData=new EvaluateVO[gradeSummaries.length];


        for (int i = 0; i < gradeSummaries.length; i++) {
            GradeSummary gradeSummary = gradeSummaries[i];
            EvaluateVO evaluateVO = new EvaluateVO();

                // 将gradeSummary的属性转化为evaluateVO的属性
            Student student=userMapper.getStudentBySid(gradeSummary.getStudentId());

            evaluateVO.setName(student.getName());
            evaluateVO.setStudentNumber(student.getStudentNumber());
            evaluateVO.setSocialPracticeGrade(gradeSummary.getSocialPracticeGrade());
            evaluateVO.setResearchGrade(gradeSummary.getResearchGrade());
            evaluateVO.setVolunteerServiceGrade(gradeSummary.getVolunteerServiceGrade());
            evaluateVO.setAcademicGrade(gradeSummary.getAcademicGrade());
            evaluateVO.setStudentLeadershipGrade(gradeSummary.getStudentLeadershipGrade());
            evaluateVO.setPersonalSummaryGrade(gradeSummary.getPersonalSummaryGrade());
            evaluateVO.setSumGrade(gradeSummary.getSumGrade());

                // 将转换后的evaluateVO对象存储在evaluateData数组中
            evaluateData[i] = evaluateVO;
        }

            return CommonResult.success(evaluateData);
    }


    @CrossOrigin       //后端跨域
    @PostMapping("/sumbitrev")
    public  CommonResult<?>  sumbitrev(@RequestBody ReviewerVO[] reviewerVOS){
        for (ReviewerVO reviewerVO: reviewerVOS) {
            if (userMapper.getUser(reviewerVO.getId())==null){
                User user=new User();
                user.setUsername(reviewerVO.getId());
                user.setPassword(reviewerVO.getId());
                userMapper.setUser(user);
                user = userMapper.getUser(reviewerVO.getId());
                UserRole userRole=new UserRole();
                userRole.setUser_id(user.getId());
                for (int i=0;i<reviewerVO.getLevel().length;i++) {
                    userRole.setRole_id(reviewerVO.getLevel()[i]);
                    roleMapper.setUserToRev(userRole);
                }

            }
        }


        return CommonResult.success("ok");

    }













}
