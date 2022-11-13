package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.FriendApply;
import com.go.ogamprj.dto.FriendSend;

import java.util.List;
import java.util.Map;

public interface FriendDiaryService {

    List<Map<String, Object>> friendListSelectAll(String myEmail);

    int friendListCount(String myEmail);

    List<Map<String, Object>> search(String myEmail, String searchKeyword);

    void deleteFriend(String myEmail, String nickname);

    List<Map<String, Object>> friendSendSelectAll(String myEmail);

    void insertfriendList(FriendApply friendApply);

    void deleteFriendSend(Integer fri_send_seq);

    List<Map<String, Object>> memberSelectAll(String myEmail);

    void insertfriendSend(FriendSend friendSend);

    List<Map<String, Object>> memberSearch(String myEmail, String searchKeyword);

    int sendValid(String myEmail);
}
