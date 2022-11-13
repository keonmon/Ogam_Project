package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SignupMapper {
    public void signup(Member member);

    @Select("select count(*) from member where member_nick = #{member_nick}")
    int uniqueChk(String member_nick);

    @Select("select count(*) from member where member_email = #{member_email}")
    int uniqueEmail(String member_email);
}
