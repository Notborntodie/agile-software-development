package com.web.test.Mapper;

import com.web.test.DO.*;
import com.web.test.VO.EvaluateVO;
import com.web.test.VO.LoginRequest;
import com.web.test.VO.Userpass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //UserDemo findByUsername(String username);
    void insert(UserDemo userDemo);

    void changeinfo(UserDemo userDemo);

    void changepass(User user);

    User getUser(String username);
    void   setUser(User user);

    void  setStudent(Student student);


    void changeStudent(Student student);


    void updateStudent(Student student);

    Student getStudentByUid(int userid);


    Student getStudentBySid(int studentId);

    void setGradeSummary(GradeSummary gradesummary);

    void changeGpa(GradeSummary gradeSummary);



    GradeSummary  findByStudentId(int studentId);


    GradeSummary[]  getAllGrade();

    PersonalSummary[] getAllPersonalSummary();

    Research[] getAllResearch();
    VolunteerService[] getAllVolunteerService();
    SocialPractice[] getAllSocialPractice();

    StudentLeadership[] getAllStudentLeadership();




    PersonalSummary findByPersonalSummaryContent(String content);

    void updatePersonalSummaryGrade(GradeSummary gradeSummary);
    void updateResearchGrade(GradeSummary gradeSummary);

    void updateStudentLeadershipGrade(GradeSummary gradeSummary);
    void updatesocialPracticeGrade(GradeSummary gradeSummary);

    void updateVolunteerServiceGrade(GradeSummary gradeSummary);




    PersonalSummary psfindBysid(int studentId);
    void insertps(PersonalSummary personalSummary);
    void updateps(PersonalSummary personalSummary);


    Research rfindBysid(int studentId);
    void insertr(Research research);
    void updater(Research research);


    SocialPractice spfindBysid(int studentId);
    void insertsp(SocialPractice socialPractice);

    void updatesp(SocialPractice socialPractice);


    StudentLeadership slfindBysid(int studentId);
    void insertsl(StudentLeadership studentLeadership);
    void updatesl(StudentLeadership studentLeadership);

    VolunteerService vsfindBysid(int studentId);
    void insertvs(VolunteerService volunteerService);
    void updatevs(VolunteerService volunteerService);










    Student findByUsername(String username);



}