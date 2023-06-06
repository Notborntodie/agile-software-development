package com.web.test.DO;

import lombok.Data;

@Data
public class UserRole {
    private  int user_id;

    private  int  role_id;

    public  UserRole(){

    }


    public  UserRole(int user_id,int role_id){
        this.user_id=user_id;
        this.role_id=role_id;
    }
}
