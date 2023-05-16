package com.web.test;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}