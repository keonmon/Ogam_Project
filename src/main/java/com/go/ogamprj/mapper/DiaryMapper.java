package com.go.ogamprj.mapper;


import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.dto.Emotions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Select("select emoji from emotions where emotion_seq = #{emotion_seq}")
    public String getEmojiSelectOne(int emotion_seq);

    public void bgimageInsert(Bgimage bgimageDto);

    //@Select("select max(bgimg_seq) from bgimage")
    //public int bgimageSelectLastSeq();

    public void diaryInsertWithBgimg(Diary diaryDto);

    public void diaryInsertNoBgimg(Diary diaryDto);

    @Select("select max(diary_seq) from diary")
    public int diarySelectLastOne();

    public HashMap<String,Object> diarySelectOne(int diarySeq);

    @Select("select count(*) from diary_like where diary_seq = #{diary_seq}")
    public int likeCnt(int diary_seq);

    @Select("select member_email from diary_like where diary_seq = #{diary_seq}")
    public List<String> likeMemberList(int diary_seq);

    public List<HashMap<String,Object>> replySelect(int diarySeq);

}

