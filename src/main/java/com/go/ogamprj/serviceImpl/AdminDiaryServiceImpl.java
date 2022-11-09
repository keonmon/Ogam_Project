package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.mapper.AdminDiaryMapper;
import com.go.ogamprj.sevice.AdminDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminDiaryServiceImpl implements AdminDiaryService {

    @Autowired
    public AdminDiaryMapper adminDiaryMapper;

    /* USER 일기 전체 가져오기 */
    @Override
    public List<HashMap<String, Object>> userDiarySelectAll() {

        return adminDiaryMapper.userDiarySelectAll();
    }
}
