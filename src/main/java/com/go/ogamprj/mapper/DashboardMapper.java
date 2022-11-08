package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

@Mapper
public interface DashboardMapper {

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_QUITED IS NULL AND MEMBER_EMAIL <> 'admin'")  // 탈퇴환 회원 제외, admin 계정 제외
    int users();

    @Select("SELECT COUNT(*) FROM MEMBER WHERE MEMBER_QUITED IS NOT NULL AND MEMBER_EMAIL <> 'admin'") // 탈퇴한 회원만 admin 계정 제외
    int removeUser();

    @Select("SELECT COUNT(*) FROM DIARY WHERE DIARY_DEL = 'n'") // 삭제한 일기 제외
    int diary();

    @Select("SELECT COUNT(*) FROM MEMBER T1, BLACKLIST_DIARY T2, BLACKLIST_REPLY T3 WHERE T1.MEMBER_EMAIL = T2.MEMBER_EMAIL AND T1.MEMBER_EMAIL = T3.MEMBER_EMAIL")
    int reply();  // 신고 요청된 개수(일기 + 댓글)

    HashMap<String, Integer> emotionChartMap(); // 차트 1달 이내의 데이터만 가져오기

}
