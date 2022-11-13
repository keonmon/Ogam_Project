package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface AdminUserService {

    public ArrayList<Member> userSelectAll();                               // USER 전체 가져오기

    ArrayList<Member> userSelectKeyword(String type, String keyword);       // 키워드 검색

    Map<String, Object> userSelectOne(String member_email);                 // 사용자 상세 정보

    int diaryCount(String member_email);    // 일기 신고 count

    int replyCount(String member_email);    // 댓글 신고 count

    void userUpdate(Member member);         // 계정 정지

}