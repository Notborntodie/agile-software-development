package com.web.test.VO;

import lombok.Data;

@Data
public class StudentEvaluateVO {

    private String Name;
    private String StudentNumber;

    private float academicGrade;

    private String PersonalSummaryContent;


    private String ResearchContent;

    private String SocialPracticeContent;


    private String StudentLeadershipContent;

    private String VolunteerServiceContent;


    public StudentEvaluateVO(){

    }

}
