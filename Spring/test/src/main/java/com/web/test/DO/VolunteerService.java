package com.web.test.DO;


import lombok.Data;

@Data
public class VolunteerService {
    private int ID;
    private int StudentId;
    private String VolunteerServiceContent;

    public VolunteerService() {
        // 无参数的构造函数
    }

    public VolunteerService(int ID, int StudentId, String VolunteerServiceContent) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.VolunteerServiceContent = VolunteerServiceContent;
    }
}

