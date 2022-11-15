package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.MemberMapper;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public HashMap<String, Object> findMember(String member_email) {
        return memberMapper.findMember(member_email);
    }

    @Override
    public void reviseUpdate(Bgimage bgimgDto, Member member) {
        memberMapper.proPhotoUpdate(bgimgDto);
        memberMapper.reviseUpdate(member);
    }

    @Override
    public void noProfile(Member member) {
        memberMapper.noProfile(member);
    }

    @Override
    public void memberUpdateResetBgimg(Member member) {
        memberMapper.memberUpdateResetBgimg(member);
    }


}
