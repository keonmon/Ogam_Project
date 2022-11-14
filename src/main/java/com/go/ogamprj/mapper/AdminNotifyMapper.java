package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminNotifyMapper {

    List<Map<String, Object>> notifySelectAll();                                    // 신고 기록 전체 가져오기

    List<Map<String, Object>> notifySelectKeyword(String type, String keyword);     // 키워드 검색

    void notifyDelete(int index);

//    삭제를 위한 카테고리
    List<HashMap<String, Object>> allBlackList();

  List<HashMap<String, String>> gbn();

//    일기삭제
    void delBlackDiary(int blackList_seq);
//    댓글삭제
    void delBlackRely(int blackList_seq);
}
