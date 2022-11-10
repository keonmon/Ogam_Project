package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDiaryMapper {

    List<Map<String, Object>> userDiarySelectAll();  // uSER 일기 전체 가져오기

}
