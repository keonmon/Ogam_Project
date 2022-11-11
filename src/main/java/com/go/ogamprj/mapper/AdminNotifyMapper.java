package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminNotifyMapper {

    List<Map<String, Object>> notifySelectAll();                                    // 신고 기록 전체 가져오기

    List<Map<String, Object>> notifySelectKeyword(String type, String keyword);     // 키워드 검색
}
