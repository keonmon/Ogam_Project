package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.LoginMapper;
import com.go.ogamprj.sevice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginMapper loginMapper;


    @Override
    public boolean loginvalid(String member_email, String member_pw) {

        return loginMapper.loginvalid(member_email, member_pw) == 1;
    }
}
