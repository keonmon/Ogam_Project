package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.FriendDiaryMapper;
import com.go.ogamprj.sevice.FriendDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FriendDiaryServiceImpl implements FriendDiaryService {

    @Autowired
    FriendDiaryMapper friendDiaryMapperMapper;

    // 친구 목록 전체 가져오기
    @Override
    public List<Map<String, Object>> friendListSelectAll(String myEmail) {
        List<Map<String, Object>> friendList = friendDiaryMapperMapper.friendListSelectAll(myEmail);
        return friendList;
    }

    // 친구 리스트 카운트
    @Override
    public int friendListCount(String myEmail) {
        return friendDiaryMapperMapper.friendListCount(myEmail);
    }
}
