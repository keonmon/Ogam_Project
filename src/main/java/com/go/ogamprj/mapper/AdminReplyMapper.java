package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminReplyMapper {

    public List<HashMap<String, Object>> userReplySelectAll();                              // USER 댓글 전체 가져오기

    List<HashMap<String, Object>> userReplySelectKeyword(String type, String keyword);      // 키워드 검색
}
