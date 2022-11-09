package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminDiaryMapper {

    /* USER 일기 전체 가져오기 */
    public List<HashMap<String, Object>> userDiarySelectAll();
}
