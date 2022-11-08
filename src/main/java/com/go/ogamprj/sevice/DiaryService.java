package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Emotions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DiaryService {
    public List<HashMap<String,Object>> oneDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> friendDiarySelectAll(String myEmail);

    public List<HashMap<String,Object>> randomAllDiarySelectAll();

    public ArrayList<Emotions> getEmotions(String emotion);

    public String getEmojiSelectOne(int emotion_seq);
}
