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
    public void updateUserPassword(String uuid, String member_email) {
        loginMapper.updateUserPassword(uuid, member_email);
    }
}
