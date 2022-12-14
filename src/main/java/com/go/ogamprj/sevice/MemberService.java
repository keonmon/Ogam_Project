package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
    public HashMap<String, Object> findMember(String member_email);

    public void reviseUpdate(Bgimage bgimgDto, Member member);

    public void noProfile(Member member);

    void memberUpdateResetBgimg(Member member);
}
