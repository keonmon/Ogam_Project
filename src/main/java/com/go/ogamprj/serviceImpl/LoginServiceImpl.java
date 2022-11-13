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

    @Override
    public boolean findid(String member_birth, String member_phone) {
        System.out.println("Impl=" + member_birth + " " + member_phone);
        System.out.println("행 개수=" +loginMapper.findid(member_birth, member_phone));
        return loginMapper.findid(member_birth, member_phone) == 1;
    }

    @Override
    public boolean findpw(String member_email, String member_phone) {
        System.out.println("Impl=" + member_email + " " + member_phone);
        System.out.println("행 개수=" + loginMapper.findpw(member_email, member_phone));
        return loginMapper.findpw(member_email, member_phone) == 1;
    }
}
