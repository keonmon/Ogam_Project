package com.go.ogamprj.mapper;


import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.dto.Emotions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    public List<HashMap<String,Object>> randomAllDiarySelectAll(String myEmail);

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

    public void diaryUpdateNoBgimg(Diary diaryDto);

    public void diaryUpdateWithBgimg(Diary diaryDto);

    public void replyUpdate(int reply_seq, String reply);

    @Select("select diary_seq from reply where reply_seq = #{reply_seq}")
    public int getDiarySeq(int reply_seq); // 해당 댓글이 달린 일기번호 가져오기

    public void diaryDelete(int diary_seq);

    public void replyDelete(int reply_seq);

    public void diaryReportInsert(int diary_seq, String member_email, String blacklist_user_email, String blacklist_comment);
    public void replyReportInsert(int reply_seq, String member_email, String blacklist_member_email, String blacklist_comment);

    void replyInsert(Map<String, Object> replyMap);

    void likeInsert(String member_email, int diary_seq);

    void likeDelete(String member_email, int diary_seq);

    List<Map<String,Object>> calendarDiarySelectAll(String memberSeq);

    List<Map<String, Object>> frndCalendarDiarySelectAll(String memberSeq);

    void notifyReplyInsert(Map<String, Object> replyMap);

    void notifyLikeInsert(Map<String, Object> map);

    @Select("select count(*) from notifi where diary_seq = #{diarySeq} and noti_email = #{loginUser} and noti_type = 'like'")
    int notifyLikeSelectCnt(Map<String, Object> map);

    @Update("update diary set emotion_seq = #{EMOTION_SEQ}, contents = #{CONTENTS} , diary_private=#{DIARY_PRIVATE},BGIMG_SEQ=NULL where diary_seq = #{DIARY_SEQ} ")
    void diaryUpdateResetBgimg(Diary diaryDto);
}

