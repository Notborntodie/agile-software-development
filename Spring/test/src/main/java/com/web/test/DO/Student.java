package com.web.test.DO;

import lombok.Data;

@Data


public class Student {
    private int Id;
    private int UserId;
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

    public Student() {
    }

    public Student(int Id, int UserId, String Name, String StudentNumber, String Gender, String PhoneNumber,
                   String Email, int Year, String AcademyDictionary, String MajorDictionary,
                   String PoliticalStatusDictionary, String StudentTypeDictionary) {
        this.Id = Id;
        this.UserId = UserId;
        this.Name = Name;
        this.StudentNumber = StudentNumber;
        this.Gender = Gender;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Year = Year;
        this.AcademyDictionary = AcademyDictionary;
        this.MajorDictionary = MajorDictionary;
        this.PoliticalStatusDictionary = PoliticalStatusDictionary;
        this.StudentTypeDictionary = StudentTypeDictionary;
    }

}



