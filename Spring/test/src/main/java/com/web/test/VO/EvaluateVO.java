package com.web.test.VO;
import lombok.Data;

@Data
public class EvaluateVO {
    private String name;
    private String studentNumber;
    private float socialPracticeGrade;
    private float researchGrade;
    private float volunteerServiceGrade;
    private float academicGrade;
    private float studentLeadershipGrade;
    private float personalSummaryGrade;
    private float sumGrade;


    public EvaluateVO(){

    }

    // 构造方法
    public EvaluateVO(String name, String studentNumber, float socialPracticeGrade, float researchGrade,
                      float volunteerServiceGrade, float academicGrade, float studentLeadershipGrade,
                      float personalSummaryGrade, float sumGrade) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.socialPracticeGrade = socialPracticeGrade;
        this.researchGrade = researchGrade;
        this.volunteerServiceGrade = volunteerServiceGrade;
        this.academicGrade = academicGrade;
        this.studentLeadershipGrade = studentLeadershipGrade;
        this.personalSummaryGrade = personalSummaryGrade;
        this.sumGrade = sumGrade;
    }


}

