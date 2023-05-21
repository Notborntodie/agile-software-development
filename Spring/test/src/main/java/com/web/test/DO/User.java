package com.web.test.DO;

import lombok.Data;

@Data
public class User {
    private  int Id;
    private  String Username;
    private  String Password;


    public User(){

    }
    public  User(int  Id,String  Username ,String Password){
        this.Id = Id;
        this.Username = Username;
        this.Password = Password;
    }

}
