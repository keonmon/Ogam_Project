package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.User_OthersDiaryMapper;
import com.go.ogamprj.sevice.User_OthersDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class User_OthersDiaryImpl implements User_OthersDiaryService {

    @Autowired
    User_OthersDiaryMapper user_othersDiaryMapper;

    @Override
    public List<Map<String, Object>> selectDiary() {
        return user_othersDiaryMapper.selectDiary();
    }

    @Override
    public List<Map<String, Object>> selectDiaryAll(String myEmail) {
        return user_othersDiaryMapper.selectDiaryAll(myEmail);
    }

    @Override
    public List<Map<String, Object>> selectDiaryByHappy(String myEmail, String emotion) {
        return user_othersDiaryMapper.selectDiaryByHappy(myEmail,emotion);
    }
}
