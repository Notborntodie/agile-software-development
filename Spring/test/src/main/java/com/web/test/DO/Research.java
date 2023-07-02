package com.web.test.DO;

import lombok.Data;

@Data
public class Research {
    private int ID;
    private int StudentId;

    private String ResearchContent;

    public Research() {
        // 无参数的构造函数
    }

    public Research(int ID, int StudentId, String ResearchContent) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.ResearchContent = ResearchContent;
    }
}
