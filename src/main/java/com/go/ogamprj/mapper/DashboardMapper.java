package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface DashboardMapper {

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_QUITED IS NULL AND MEMBER_EMAIL <> 'admin'")  // 탈퇴환 회원 제외, admin 계정 제외
    int users();

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_QUITED IS NOT NULL AND MEMBER_EMAIL <> 'admin'") // 탈퇴한 회원만 admin 계정 제외
    int removeUser();

    @Select("SELECT COUNT(*) FROM DIARY WHERE DIARY_DEL = 'n'") // 삭제한 일기 제외
    int diary();

    List<HashMap<String, Object>> blackcnt();  // 신고 요청된 개수(일기 + 댓글)

    ArrayList<String> emotionList(); // 차트 1달 이내의 데이터만 가져오기 Emoation
    ArrayList<Integer> cntList(); // 차트 1달 이내의 데이터만 가져오기 CNT

    int diaryCnt(); // 오늘 하루동안 몇명이 일기쓴 일기 개수

    int memberCnt(); // 한달 동안 가입한 신규 회원 수
}
