package com.go.ogamprj.sevice;


import java.util.List;
import java.util.Map;

public interface AdminNotifyService {

    List<Map<String,Object>> notifySelectAll();                                     // 신고 기록 전체 가져오기

    List<Map<String,Object>> notifySelectKeyword(String type, String keyword);      // 키워드 검색

    void notifyDelete(int index);
}
