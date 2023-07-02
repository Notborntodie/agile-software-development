package com.web.test.DO;


import lombok.Data;
@Data
public class PersonalSummary {
    private int ID;
    private int StudentId;
    private String PersonalSummaryContent;

    public PersonalSummary() {
        // 无参数的构造函数
    }

    public PersonalSummary(int ID, int StudentId, String PersonalSummaryContent) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.PersonalSummaryContent = PersonalSummaryContent;
    }
}
