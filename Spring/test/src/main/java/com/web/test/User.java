package com.web.test;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;

    private String name;
    private String idCard;
    private String phone;
    private String email;

    public User() {
    }

    public User(String username, String password, String name, String idCard, String phone, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

}
