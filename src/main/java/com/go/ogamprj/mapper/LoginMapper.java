package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

   @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = #{member_email} AND MEMBER_PW = #{member_pw}")
    int loginvalid(String member_email, String member_pw);

   @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_BIRTH = #{member_birth} AND MEMBER_PHONE = #{member_phone}")
    int findid(String member_birth, String member_phone);

   @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = #{member_email} AND MEMBER_PHONE = #{member_phone}")
    int findpw(String member_email, String member_phone);
}
