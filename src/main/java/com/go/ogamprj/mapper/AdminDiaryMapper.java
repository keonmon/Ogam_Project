package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDiaryMapper {

    List<Map<String, Object>> userDiarySelectAll();                                     // USER 일기 전체 가져오기

    List<Map<String, Object>> userDiarySelectKeyword(String type, String keyword);      // 키워드 검색

    void diaryDelete(int diary_seq);                           // 일기 삭제

    Map<String, Object> diarySelectOne(int diary_seq);        // 일기 상세보기

    int diaryCount(int diary_seq);                            // 일기 신고 횟수
}
