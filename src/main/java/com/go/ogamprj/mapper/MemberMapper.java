package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

@Mapper
public interface MemberMapper {
    public HashMap<String, Object> findMember(String member_email);

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_NICK = #{member_nick} AND MEMBER_EMAIL <> #{member_email}")
    public int uniqueChk(String member_nick, String member_email);

    public void reviseUpdate(Member member);
    public void proPhotoUpdate(Bgimage bgimgDto);

    public void noProfile(Member member);

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = #{member_email} AND MEMBER_PW = #{member_pw}")
    public int delMemberPwd(String member_email, String member_pw);

    public void delMember(String member_quited_reason, String member_email);

    void kakaoUserInsert(HashMap<String, Object> userInfo);

    @Select("select * from member where kakaoId = #{kakaoId}")
    HashMap<String,Object> kakaoUserCheck(Object kakaoId);
}
