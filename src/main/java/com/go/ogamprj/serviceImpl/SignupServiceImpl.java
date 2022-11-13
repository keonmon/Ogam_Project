package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.SignupMapper;
import com.go.ogamprj.sevice.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    SignupMapper signupMapper;


    @Override
    public Member insert(Member member) {

        System.out.println(member);

        signupMapper.signup(member);

        return member;
    }

    @Override
    public int uniqueChk(String member_nick) {
        int uniqueChk = signupMapper.uniqueChk(member_nick);
        return uniqueChk;
    }
}
