package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Diary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface AdminDiaryService {

    /* USER 일기 전체 가져오기 */
    public List<HashMap<String, Object>> userDiarySelectAll();
}
