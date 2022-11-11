package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.friendApply;
import com.go.ogamprj.dto.friendSend;
import com.go.ogamprj.mapper.FriendDiaryMapper;
import com.go.ogamprj.sevice.FriendDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FriendDiaryServiceImpl implements FriendDiaryService {

    @Autowired
    FriendDiaryMapper friendDiaryMapper;

    // 친구 목록 전체 가져오기
    @Override
    public List<Map<String, Object>> friendListSelectAll(String myEmail) {
        List<Map<String, Object>> friendList = friendDiaryMapper.friendListSelectAll(myEmail);
        return friendList;
    }

    // 친구 리스트 카운트
    @Override
    public int friendListCount(String myEmail) {
        return friendDiaryMapper.friendListCount(myEmail);
    }

    // 검색으로 친구리스트 가져오기
    @Override
    public List<Map<String, Object>> search(String searchKeyword) {
        return friendDiaryMapper.search(searchKeyword);
    }

    // 친구 리스트 삭제
    @Override
    public void deleteFriend(String myEmail, String nickname) {
        friendDiaryMapper.deleteFriend(myEmail, nickname);
    }

    // 친구 신청 전체 가져오기
    @Override
    public List<Map<String, Object>> friendSendSelectAll(String myEmail) {
        return friendDiaryMapper.friendSendSelectAll(myEmail);
    }

    // member 전체 유저 가져오기
    @Override
    public List<Map<String, Object>> memberSelectAll() {
        return friendDiaryMapper.memberSelectAll();
    }

    // 친구 신청하기
    @Override
    public void insertfriendSend(friendSend friendSend) {
        friendDiaryMapper.insertfriendSend(friendSend);
    }

    // 친구 리스트에 insert
    @Override
    public void insertfriendList(friendApply friendApply) {
        friendDiaryMapper.insertfriendList(friendApply);
        friendDiaryMapper.insertfriendList2nd(friendApply);
    }

    // 친구 신청 삭제
    @Override
    public void deleteFriendSend(String myEmail, String member_op_email) {
        friendDiaryMapper.deleteFriendSend(myEmail, member_op_email);
    }



}
