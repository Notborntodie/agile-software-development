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

    void changepass(Userpass userpass);

    User getUser(String username);
    void   setUser(User user);

    void  setStudent(Student student);

    Student getStudentByUid(int userid);


    Student getStudentBySid(int studentId);

    void setGradeSummary(GradeSummary gradesummary);

    GradeSummary  findByStudentId(int studentId);


    GradeSummary[]  getAllGrade();

     PersonalSummary[] getAllPersonalSummary();

    PersonalSummary findByPersonalSummaryContent(String content);

    void updatePersonalSummaryGrade(GradeSummary gradeSummary);




    Student findByUsername(String username);



}