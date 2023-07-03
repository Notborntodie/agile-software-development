package com.web.test.DO;

import lombok.Data;

@Data
public class Research {
    private int ID;
    private int StudentId;

    private String ResearchContent;

    private String FilePath;

    public Research() {
        // 无参数的构造函数
    }

    public Research(int ID, int StudentId, String ResearchContent,String filePath) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.ResearchContent = ResearchContent;
        this.FilePath=filePath;
    }
}
