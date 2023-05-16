package com.web.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findByUsername(String username);
    void insert(User user);

    void changeinfo(User user);

    void changepass(Userpass userpass);
}