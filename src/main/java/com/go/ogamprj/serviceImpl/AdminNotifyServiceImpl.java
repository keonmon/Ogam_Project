package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.AdminNotifyMapper;
import com.go.ogamprj.sevice.AdminNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminNotifyServiceImpl implements AdminNotifyService {

    @Autowired
    AdminNotifyMapper adminNotifyMapper;

    /* 신고 기록 전체 가져오기 */
    @Override
    public List<Map<String, Object>> notifySelectAll() {
        return adminNotifyMapper.notifySelectAll();
    }

    /* 키워드 검색 */
    @Override
    public List<Map<String, Object>> notifySelectKeyword(String type, String keyword) {
        return adminNotifyMapper.notifySelectKeyword(type, keyword);
    }
}
