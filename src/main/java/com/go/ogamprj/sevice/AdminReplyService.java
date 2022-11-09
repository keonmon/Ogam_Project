package com.go.ogamprj.sevice;

import java.util.HashMap;
import java.util.List;

public interface AdminReplyService {

    /* USER 댓글 전체 가져오기 */
    public List<HashMap<String, Object>> userReplySelectAll();
}
