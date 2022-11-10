package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.MemberMapper;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public Member findMember(String member_email) {
        return memberMapper.findMember(member_email);
    }

    @Override
    public void reviseUpdate(Member member) {
        memberMapper.reviseUpdate(member);
    }

    @Override
    public Optional<Bgimage> profile(Long id) {
        return Optional.empty();
    }

}
