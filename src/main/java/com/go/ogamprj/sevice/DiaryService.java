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
}
