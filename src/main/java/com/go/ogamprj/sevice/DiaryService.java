package com.go.ogamprj.sevice;


import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.dto.Emotions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DiaryService {
    public List<HashMap<String,Object>> oneDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> friendDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> randomAllDiarySelectAll();

    public ArrayList<Emotions> getEmotions(String emotion);

    public String getEmojiSelectOne(int emotion_seq);

    public void diaryInsertWithBgimg(Bgimage bgimageDto, Diary diaryDto);

    public int diarySelectLastOne();

    public void diaryInsertNoBgimg(Diary diaryDto);

    public HashMap<String,Object> diarySelectOne(int diarySeq);


    public HashMap<String,Object> likeMap(int diary_seq);

    List<HashMap<String,Object>> replySelect(int diarySeq);

    public void diaryUpdateNoBgimg(Diary diaryDto);

    public void diaryUpdateWithBgimg(Bgimage bgimageDto, Diary diaryDto);

    public void replyUpdate(int reply_seq, String reply);

    public int getDiarySeq(int reply_seq);

    void diaryDelete(int diary_seq);

    public void replyDelete(int reply_seq);

    void diaryReportInsert(int diary_seq, String member_email, String blacklist_user_email, String blacklist_comment);
    void replyReportInsert(int reply_seq, String member_email, String blacklist_member_email, String blacklist_comment);

    void replyInsert(Map<String, Object> replyMap);


    void likeInsert(String member_email, int diary_seq);

    void likeDelete(String member_email, int diary_seq);

    List<Map<String,Object>> calendarDiarySelectAll(String memberSeq);

    List<Map<String, Object>> frndCalendarDiarySelectAll(String memberSeq);
}
