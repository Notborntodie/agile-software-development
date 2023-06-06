package com.web.test.Mapper;

import com.web.test.DO.*;
import com.web.test.VO.EvaluateVO;
import com.web.test.VO.LoginRequest;
import com.web.test.VO.Userpass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    List<String> findRole(String username);
    List<String> findUrls(String username);


    Menu[] getMenu(String username);


    void setUserToStu(int user_id);

    void setUserToRev(UserRole userRole);
}
