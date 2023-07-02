package com.web.test.VO;


import lombok.Data;

@Data
public class ReviewerVO {

    private String name;

    private String id;

    private int[] level;

    public  ReviewerVO(){

    }

    public  ReviewerVO(String name,String id,int [] level){
        this.name=name;
        this.id=id;
        this.level=level;
    }
}
