package com.web.test.DO;

import lombok.Data;

@Data
public class SocialPractice {
    private int ID;
    private int StudentId;
    private String SocialPracticeContent;

    public SocialPractice() {
        // 无参数的构造函数
    }

    public SocialPractice(int ID, int StudentId, String SocialPracticeContent) {
        this.ID = ID;
        this.StudentId = StudentId;
        this.SocialPracticeContent = SocialPracticeContent;
    }
}
