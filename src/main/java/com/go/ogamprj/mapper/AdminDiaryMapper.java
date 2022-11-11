package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDiaryMapper {

    List<Map<String, Object>> userDiarySelectAll();                                     // USER 일기 전체 가져오기

    List<Map<String, Object>> userDiarySelectKeyword(String type, String keyword);      // 키워드 검색

}
