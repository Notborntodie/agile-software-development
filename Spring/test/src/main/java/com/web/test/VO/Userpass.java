package com.web.test.VO;

import lombok.Data;

@Data
public class Userpass {
    private String username;
    private String oldpassword;

    private String newpassword;

    public Userpass() {
    }

    public Userpass(String username, String oldpassword,String newpassword) {
        this.username = username;
        this.oldpassword=oldpassword;
        this.newpassword=newpassword;
    }

}