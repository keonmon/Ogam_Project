package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminUserMapper {

//    @Select("select * from member")
    ArrayList<Member> userSelectAll();                                      // USER 전체 가져오기
    
    ArrayList<Member> userSelectKeyword(String type, String keyword);       // 키워드 검색

    Map<String, Object> userSelectOne(String member_email);           // 사용자 정보 팝업

    int diaryCount(String member_email);        // 일기 신고 수

    int replyCount(String member_email);        // 댓글 신고 수

    void userUpdate(Member member);             // 계정 정지
}
