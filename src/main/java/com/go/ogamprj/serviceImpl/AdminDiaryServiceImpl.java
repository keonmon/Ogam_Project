package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.AdminDiaryMapper;
import com.go.ogamprj.sevice.AdminDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminDiaryServiceImpl implements AdminDiaryService {

    @Autowired
    AdminDiaryMapper adminDiaryMapper;

    /* USER 일기 전체 가져오기 */
    @Override
    public List<Map<String, Object>> userDiarySelectAll() {
        return adminDiaryMapper.userDiarySelectAll();
    }

    /* 키워드 검색 */
    @Override
    public List<Map<String, Object>> userDiarySelectKeyword(String type, String keyword) {
        return adminDiaryMapper.userDiarySelectKeyword(type, keyword);
    }

    /* 일기 상세 보기 */
    @Override
    public Map<String, Object> diarySelectOne(int diary_seq) {
        return adminDiaryMapper.diarySelectOne(diary_seq);
    }

    /* 일기 신고 수 */
    @Override
    public int diaryCount(int diary_seq) {
        return adminDiaryMapper.diaryCount(diary_seq);
    }

    /* 일기 삭제 - (목록) */
    @Override
    public void diaryDelete(int diary_seq) {
        adminDiaryMapper.diaryDelete(diary_seq);
    }


}
