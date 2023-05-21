package com.web.test.DO;



import lombok.Data;

@Data
public class StudentLeadership {
    private int ID;
    private int StudentId;
    private String StudentLeadershipContent;

    public StudentLeadership() {
        // 无参数的构造函数
    }

    public StudentLeadership(int ID, int StudentId, String StudentLeadershipContent) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.StudentLeadershipContent= StudentLeadershipContent;
    }
}

