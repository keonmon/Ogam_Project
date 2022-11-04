package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Diary;

import java.util.HashMap;
import java.util.List;

public interface DiaryService {
    public List<HashMap<String,Object>> oneDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> friendDiarySelectAll(String myEmail);

}
