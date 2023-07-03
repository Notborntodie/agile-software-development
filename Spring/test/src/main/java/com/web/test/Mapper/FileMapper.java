package com.web.test.Mapper;



import com.web.test.DO.*;
import com.web.test.VO.EvaluateVO;
import com.web.test.VO.LoginRequest;
import com.web.test.VO.Userpass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper {
    void insertr(Research research);
    void updater(Research research);


}