package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface LoginMapper {

   @Select("SELECT * FROM MEMBER m " +
           "join bgimage b " +
           "on b.member_email = m.member_email " +
           "WHERE m.MEMBER_EMAIL = #{member_email}")
   Map<String,Object> memberSelectOne(String member_email);

   @Select("SELECT member_email FROM MEMBER WHERE MEMBER_BIRTH = #{member_birth} AND MEMBER_PHONE = #{member_phone}")
   String idFindSelectOne(String member_birth, String member_phone);

   @Update("update member set MEMBER_PW = #{uuid} where MEMBER_EMAIL = #{member_email}")
   void updateUserPassword(String uuid, String member_email);
}
