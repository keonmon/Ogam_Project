package com.go.ogamprj.sevice;

import java.util.List;
import java.util.Map;

public interface FriendDiaryService {

    List<Map<String, Object>> friendListSelectAll(String myEmail);

    int friendListCount(String myEmail);
}
