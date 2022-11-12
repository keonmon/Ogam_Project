package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface User_OthersDiaryMapper {

    List<Map<String, Object>> selectDiaryAll();


    List<Map<String, Object>> selectDiaryByHappy(String emotion);
}
