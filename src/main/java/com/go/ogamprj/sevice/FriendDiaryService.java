package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.friendApply;
import com.go.ogamprj.dto.friendSend;

import java.util.List;
import java.util.Map;

public interface FriendDiaryService {

    List<Map<String, Object>> friendListSelectAll(String myEmail);

    int friendListCount(String myEmail);

    List<Map<String, Object>> search(String searchKeyword);

    void deleteFriend(String myEmail, String nickname);

    List<Map<String, Object>> friendSendSelectAll(String myEmail);

    void insertfriendList(friendApply friendApply);

    void deleteFriendSend(Integer fri_send_seq);

    List<Map<String, Object>> memberSelectAll(String myEmail);

    void insertfriendSend(friendSend friendSend);

    List<Map<String, Object>> memberSearch(String searchKeyword);

}
