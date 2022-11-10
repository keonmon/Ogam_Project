package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;

import java.util.Optional;

public interface MemberService {
    public Member findMember(String member_email);

    public void reviseUpdate(Member member);

    public Optional<Bgimage> profile(Long id);
}
