package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.LoginMapper;
import com.go.ogamprj.sevice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginMapper loginMapper;


    @Override
    public Map<String,Object> memberSelectOne(String member_email) {
        return loginMapper.memberSelectOne(member_email);

    }

    @Override
    public String idFindSelectOne(String member_birth, String member_phone) {
        return loginMapper.idFindSelectOne(member_birth, member_phone);
    }

    @Override
    public boolean findpw(String member_email, String member_phone) {
        System.out.println("Impl=" + member_email + " " + member_phone);
        System.out.println("행 개수=" + loginMapper.findpw(member_email, member_phone));
        return loginMapper.findpw(member_email, member_phone) == 1;
    }
}
