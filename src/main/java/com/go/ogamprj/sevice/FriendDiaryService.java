package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.friendApply;

import java.util.List;
import java.util.Map;

public interface FriendDiaryService {

    List<Map<String, Object>> friendListSelectAll(String myEmail);

    int friendListCount(String myEmail);

    List<Map<String, Object>> search(String searchKeyword);

    void deleteFriend(String myEmail, String nickname);

    List<Map<String, Object>> friendSendSelectAll(String myEmail);

    void deleteFriendSend(String myEmail);

    void insertfriendList(friendApply friendApply);
}
