package com.web.test.Controller;

import com.web.test.DO.*;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import com.web.test.VO.CommonResult;
import com.web.test.VO.StudentEvaluateVO;
import com.web.test.VO.StudentInfoVO;
import org.apache.ibatis.jdbc.Null;
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


    @GetMapping("/getInfo")
    public  CommonResult<StudentEvaluateVO> getInfo(@RequestHeader("Authorization") String authHeader){


        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);


        StudentEvaluateVO studentEvaluateVO=new StudentEvaluateVO();
        Student student= userMapper.findByUsername(username);
        studentEvaluateVO.setName(student.getName());
        studentEvaluateVO.setStudentNumber(student.getStudentNumber());
        GradeSummary gradeSummary=userMapper.findByStudentId(student.getId());
        studentEvaluateVO.setAcademicGrade(gradeSummary.getAcademicGrade());


        PersonalSummary personalSummary=userMapper.psfindBysid(student.getId());
        Research research=userMapper.rfindBysid(student.getId());
        SocialPractice socialPractice=userMapper.spfindBysid(student.getId());
        StudentLeadership studentLeadership=userMapper.slfindBysid(student.getId());
        VolunteerService  volunteerService=userMapper.vsfindBysid(student.getId());

        if (studentLeadership!=null) {
            studentEvaluateVO.setStudentLeadershipContent(studentLeadership.getStudentLeadershipContent());
        }

        if (research!=null){
            studentEvaluateVO.setResearchContent(research.getResearchContent());
        }

        if (socialPractice!=null){
            studentEvaluateVO.setSocialPracticeContent(socialPractice.getSocialPracticeContent());
        }

        if (personalSummary!=null){
            studentEvaluateVO.setPersonalSummaryContent(personalSummary.getPersonalSummaryContent());
        }

        if (volunteerService!=null){
            studentEvaluateVO.setVolunteerServiceContent(volunteerService.getVolunteerServiceContent());
        }



        return  CommonResult.success(studentEvaluateVO);


    }



    @GetMapping ("/getBasicinfo")
    public CommonResult<StudentInfoVO> getBasicinfo(@RequestHeader("Authorization") String authHeader) {

        StudentInfoVO studentInfoVO=new StudentInfoVO();
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student= userMapper.findByUsername(username);
        studentInfoVO.setName(student.getName());
        studentInfoVO.setStudentNumber(student.getStudentNumber());
        studentInfoVO.setGender(student.getGender());
        studentInfoVO.setPhoneNumber(student.getPhoneNumber());
        studentInfoVO.setEmail(student.getEmail());
        studentInfoVO.setYear(student.getYear());
        studentInfoVO.setStudentTypeDictionary(student.getStudentTypeDictionary());
        studentInfoVO.setAcademyDictionary(student.getAcademyDictionary());
        studentInfoVO.setMajorDictionary(student.getMajorDictionary());
        studentInfoVO.setPoliticalStatusDictionary(student.getPoliticalStatusDictionary());
        return  CommonResult.success(studentInfoVO);
    }




    @PostMapping ("/changeBasicinfo")
    public CommonResult<?> changeBasicinfo(@RequestHeader("Authorization") String authHeader ,
                                         @RequestBody StudentInfoVO studentInfoVO) {

        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student = userMapper.findByUsername(username);

        student.setName(studentInfoVO.getName());
        student.setStudentNumber(studentInfoVO.getStudentNumber());
        student.setGender(studentInfoVO.getGender());
        student.setPhoneNumber(studentInfoVO.getPhoneNumber());
        student.setEmail(studentInfoVO.getEmail());
        student.setYear(studentInfoVO.getYear());
        student.setStudentTypeDictionary(studentInfoVO.getStudentTypeDictionary());
        student.setAcademyDictionary(studentInfoVO.getAcademyDictionary());
        student.setMajorDictionary(studentInfoVO.getMajorDictionary());
        student.setPoliticalStatusDictionary(studentInfoVO.getPoliticalStatusDictionary());

        userMapper.updateStudent(student);
        return CommonResult.success("ok");
    }


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


        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student= userMapper.findByUsername(username);


        if(student==null){
            return CommonResult.error(1000,"error");
        }
        PersonalSummary personalSummary=userMapper.psfindBysid(student.getId());
        Research research=userMapper.rfindBysid(student.getId());
        SocialPractice socialPractice=userMapper.spfindBysid(student.getId());
        StudentLeadership studentLeadership=userMapper.slfindBysid(student.getId());
        VolunteerService  volunteerService=userMapper.vsfindBysid(student.getId());

        if (personalSummary==null){
            personalSummary=new PersonalSummary();
            personalSummary.setStudentId(student.getId());
            personalSummary.setPersonalSummaryContent(studentEvaluateVO.getPersonalSummaryContent());
            userMapper.insertps(personalSummary);
        }else{
            personalSummary.setPersonalSummaryContent(studentEvaluateVO.getPersonalSummaryContent());
            userMapper.updateps(personalSummary);
        }

        if (research == null) {
            // Research record not found for the student
            research = new Research();
            research.setStudentId(student.getId());
            research.setResearchContent(studentEvaluateVO.getResearchContent());
            // Set other properties of research object if needed
            userMapper.insertr(research); // Assuming the insertResearch() method in userMapper takes Research object as a parameter
        } else {
            research.setResearchContent(studentEvaluateVO.getResearchContent());
            userMapper.updater(research);
        }

        if (socialPractice == null) {
            // SocialPractice record not found for the student
            socialPractice = new SocialPractice();
            socialPractice.setStudentId(student.getId());
            socialPractice.setSocialPracticeContent(studentEvaluateVO.getSocialPracticeContent());
            // Set other properties of socialPractice object if needed
            userMapper.insertsp(socialPractice); // Assuming the insertSocialPractice() method in userMapper takes SocialPractice object as a parameter
        } else {
           socialPractice.setSocialPracticeContent(studentEvaluateVO.getSocialPracticeContent());
           userMapper.updatesp(socialPractice);
        }

        if (studentLeadership == null) {
            // StudentLeadership record not found for the student
            studentLeadership = new StudentLeadership();
            studentLeadership.setStudentId(student.getId());
            studentLeadership.setStudentLeadershipContent(studentEvaluateVO.getStudentLeadershipContent());
            // Set other properties of studentLeadership object if needed
            userMapper.insertsl(studentLeadership); // Assuming the insertStudentLeadership() method in userMapper takes StudentLeadership object as a parameter
        } else {
            studentLeadership.setStudentLeadershipContent(studentEvaluateVO.getStudentLeadershipContent());
            userMapper.updatesl(studentLeadership);
            // StudentLeadership record found for the student
        }

        if (volunteerService == null) {
            // VolunteerService record not found for the student
            volunteerService = new VolunteerService();
            volunteerService.setStudentId(student.getId());
            volunteerService.setVolunteerServiceContent(studentEvaluateVO.getVolunteerServiceContent());
            // Set other properties of volunteerService object if needed
            userMapper.insertvs(volunteerService); // Assuming the insertVolunteerService() method in userMapper takes VolunteerService object as a parameter
        } else {
            volunteerService.setVolunteerServiceContent(studentEvaluateVO.getVolunteerServiceContent());
            userMapper.updatevs(volunteerService);
            // VolunteerService record found for the student
        }

        return CommonResult.success("ok");
    }




}



