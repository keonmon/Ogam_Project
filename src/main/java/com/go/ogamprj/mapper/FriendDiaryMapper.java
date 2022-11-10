package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.friendApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FriendDiaryMapper {

    // 친구 전체 목록 가져오기
    List<Map<String, Object>> friendListSelectAll(String myEmail);

    //친구 리스트 카운트
    int friendListCount(String myEmail);

    // 친구 검색
    List<Map<String, Object>> search(String searchKeyword);

    // 친구 리스트 삭제
    void deleteFriend(String myEmail, String nickname);

    // 친구 신청 리스트 전체 가져오기
    List<Map<String, Object>> friendSendSelectAll(String myEmail);

    // 친구 신청 리스트 삭제
    void deleteFriendSend(String myEmail);

    void insertfriendList(friendApply friendApply);
    void insertfriendList2nd(friendApply friendApply);
}
