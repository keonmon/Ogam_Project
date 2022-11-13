package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.MemberMapper;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public HashMap<String, Object> findMember(String member_email) {
        return memberMapper.findMember(member_email);
    }

    @Override
    public void reviseUpdate(Member member, Bgimage bgimgDto) {
        memberMapper.reviseUpdate(member);
        memberMapper.proPhotoUpdate(bgimgDto);
    }

    @Override
    public void noProfile(Member member) {
        memberMapper.noProfile(member);
    }


}
