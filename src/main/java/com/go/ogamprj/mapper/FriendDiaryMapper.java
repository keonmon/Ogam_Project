package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.FriendApply;
import com.go.ogamprj.dto.FriendSend;
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
    List<Map<String, Object>> search(String myEmail, String searchKeyword);

    // 친구 리스트 삭제
    void deleteFriend(String myEmail, String nickname);

    // 친구 신청 리스트 전체 가져오기
    List<Map<String, Object>> friendSendSelectAll(String myEmail);

    // member 친구리스트 빼고 유저 가져오기
    List<Map<String, Object>> memberSelectAll(String myEmail);

    // 멤버 검색

    List<Map<String, Object>> memberSearch(String myEmail,String searchKeyword);

    // 친구 리스트 insert
    void insertfriendList(FriendApply friendApply);

    void insertfriendList2nd(FriendApply friendApply);

    // 친구 신청 리스트 삭제
    void deleteFriendSend(Integer fri_send_seq);

    // 친구 신청하기
    void insertfriendSend(FriendSend friendSend);

    int sendValid(String myEmail);
}
