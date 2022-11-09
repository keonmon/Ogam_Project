package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FriendDiaryMapper {

    // 친구 전체 목록 가져오기
    List<Map<String, Object>> friendListSelectAll(String myEmail);

    //친구 리스트 카운트
    int friendListCount(String myEmail);

    List<Map<String, Object>> search(String searchKeyword);
}
