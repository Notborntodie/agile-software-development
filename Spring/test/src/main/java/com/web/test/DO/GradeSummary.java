package com.web.test.DO;

import lombok.Data;

@Data
public class GradeSummary {
    private int ID;
    private int studentId;
    private float socialPracticeGrade;
    private float researchGrade;
    private float volunteerServiceGrade;
    private float academicGrade;
    private float studentLeadershipGrade;
    private float personalSummaryGrade;
    private float sumGrade;

    public GradeSummary() {
    }

    public GradeSummary(int ID, int studentId, float socialPracticeGrade, float researchGrade, float volunteerServiceGrade,
                        float academicGrade, float studentLeadershipGrade, float personalSummaryGrade, float sumGrade) {
        this.ID = ID;
        this.studentId = studentId;
        this.socialPracticeGrade = socialPracticeGrade;
        this.researchGrade = researchGrade;
        this.volunteerServiceGrade = volunteerServiceGrade;
        this.academicGrade = academicGrade;
        this.studentLeadershipGrade = studentLeadershipGrade;
        this.personalSummaryGrade = personalSummaryGrade;
        this.sumGrade = sumGrade;
    }
}
