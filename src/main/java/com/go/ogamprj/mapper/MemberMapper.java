package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM MEMBER WHERE MEMBER_EMAIL = #{member_email}")
    public Member findMember(String member_email);

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_NICK == #{MEMBER_NICK}")
    public int uniqueChk(String member_nick);

}
