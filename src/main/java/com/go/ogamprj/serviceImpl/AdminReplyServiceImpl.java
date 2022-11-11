package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.AdminDiaryMapper;
import com.go.ogamprj.mapper.AdminReplyMapper;
import com.go.ogamprj.sevice.AdminDiaryService;
import com.go.ogamprj.sevice.AdminReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
}
