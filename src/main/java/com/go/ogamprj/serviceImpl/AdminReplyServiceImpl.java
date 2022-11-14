package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.AdminDiaryMapper;
import com.go.ogamprj.mapper.AdminReplyMapper;
import com.go.ogamprj.sevice.AdminDiaryService;
import com.go.ogamprj.sevice.AdminReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminReplyServiceImpl implements AdminReplyService {

    @Autowired
    AdminReplyMapper adminReplyMapper;

    /* USER 댓글 전체 가져오기 */
    @Override
    public List<HashMap<String, Object>> userReplySelectAll() {
        return adminReplyMapper.userReplySelectAll();
    }

    /* 키워드 검색 */
    @Override
    public List<HashMap<String, Object>> userReplySelectKeyword(String type, String keyword) {
        return adminReplyMapper.userReplySelectKeyword(type, keyword);
    }

    /* 댓글 상세 보기 */
    @Override
    public Map<String, Object> replySelectOne(int reply_seq) {
        return adminReplyMapper.replySelectOne(reply_seq);
    }

    /* 댓글 신고 수 */
    @Override
    public int replyCount(int reply_seq) {
        return adminReplyMapper.replyCount(reply_seq);
    }
    /* 댓글 삭제 - (목록) */
    @Override
    public void replyDelete(int reply_seq) {
        adminReplyMapper.replyDelete(reply_seq);
    }


}
