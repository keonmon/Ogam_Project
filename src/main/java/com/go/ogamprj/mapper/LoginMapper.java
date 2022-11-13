package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface LoginMapper {

   @Select("SELECT MEMBER_EMAIL, MEMBER_PW FROM MEMBER WHERE MEMBER_EMAIL = #{member_email}")
   Map<String,Object> memberSelectOne(String member_email);

   @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_BIRTH = #{member_birth} AND MEMBER_PHONE = #{member_phone}")
    int findid(String member_birth, String member_phone);

   @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_EMAIL = #{member_email} AND MEMBER_PHONE = #{member_phone}")
    int findpw(String member_email, String member_phone);
}
