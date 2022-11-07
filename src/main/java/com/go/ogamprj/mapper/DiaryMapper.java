package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Emotions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface DiaryMapper {

    public List<HashMap<String,Object>> oneDiarySelectAll(String myEmail);

    // 친구 array 가져오는 sql
    //@Select("select MEMBER_OP_EMAIL from friend_apply where MEMBER_EMAIL = #{myEmail}")
    //public String[] friendEmailSelectAll (String myEmail);

    public List<HashMap<String,Object>> friendDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> randomAllDiarySelectAll();

    @Select("select * from emotions where emotion = #{emotion}")
    public ArrayList<Emotions> getEmotions(String emotion);
}
