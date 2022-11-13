package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Diary;

import java.util.List;
import java.util.Map;

public interface AdminDiaryService {

    List<Map<String, Object>> userDiarySelectAll();                                      // USER 일기 전체 가져오기

    List<Map<String, Object>> userDiarySelectKeyword(String type, String keyword);      // 키워드 검색

    void diaryDelete(int diary_seq);    // 일기 삭제
}
