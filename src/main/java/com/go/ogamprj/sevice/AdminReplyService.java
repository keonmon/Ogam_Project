package com.go.ogamprj.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminReplyService {

    public List<HashMap<String, Object>> userReplySelectAll();                              // USER 댓글 전체 가져오기

    List<HashMap<String, Object>>  userReplySelectKeyword(String type, String keyword);     // 키워드 검색

    void replyDelete(int reply_seq);                         // 댓글 삭제 (목록에서 삭제)

    Map<String, Object> replySelectOne(int reply_seq);      // 댓글 상세 보기

    int replyCount(int reply_seq);                          // 댓글 신고 수
}
