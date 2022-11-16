package com.go.ogamprj.sevice;

import java.util.List;
import java.util.Map;

public interface User_OthersDiaryService {
    List<Map<String, Object>> selectDiary();
    List<Map<String, Object>> selectDiaryAll(String myEmail);

    List<Map<String, Object>> selectDiaryByHappy(String myEmail,String emotion);

    List<Map<String, Object>> nloginselectDiaryByMood(String emotion);
}
