package com.web.test.VO;

import lombok.Data;

@Data
public class ChangPassVO {

    private String oldpassword;

    private String newpassword;


    public ChangPassVO(){

    }

    public ChangPassVO(String oldpassword,String newpassword){
        this.oldpassword=oldpassword;
        this.newpassword=newpassword;
    }
}
