package com.web.test.VO;

import lombok.Data;

@Data
public class StudentInfoVO {
    private String Name;
    private String StudentNumber;
    private String Gender;
    private String PhoneNumber;
    private String Email;
    private int Year;
    private String AcademyDictionary;
    private String MajorDictionary;
    private String PoliticalStatusDictionary;
    private String StudentTypeDictionary;

    public  StudentInfoVO(){

    }
}
