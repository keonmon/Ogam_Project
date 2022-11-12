package com.go.ogamprj.sevice;

import java.util.List;
import java.util.Map;

public interface User_OthersDiaryService {
    List<Map<String, Object>> selectDiaryAll();

    List<Map<String, Object>> selectDiaryByHappy(String emotion);
}
